import org.json.JSONArray;
import org.json.JSONObject;

        import java.util.ArrayList;

public class Project {
    private String title;
    private ArrayList<Skills> needskil;
    private int budget;
    private ArrayList<Register> userREQ;

    Project(JSONObject object) {
        this.title = object.getString("title");
        this.needskil = new ArrayList<>();
        this.userREQ = new ArrayList<>();
        JSONArray myskills = object.getJSONArray("skills");
        for (int i = 0 ; i < myskills.length(); i++){
            Skills newskill = new Skills(myskills.getJSONObject(i));
            addSkills(newskill);
        }
        this.budget = object.getInt("budget");
    }

    String getTitle() {
        return title;
    }

    public ArrayList<Skills> getNeedskil() {
        return needskil;
    }

    public int getBudget() {
        return budget;
    }

    private void addSkills(Skills rskill){
        this.needskil.add(rskill);
    }

    boolean addreq(Register newuser, JSONObject object){
        if (object.getInt("bidAmount")>this.budget)
            return false;
        else{
            for (Skills aNeedskil : this.needskil) {
                int skillplace = newuser.getSkill().indexOf(aNeedskil);
                if (skillplace != -1) {
                    if (newuser.getSkill().get(skillplace).getPoints() < aNeedskil.getPoints())
                        return false;
                }
                else return false;

            }
            this.userREQ.add(newuser);
        }
     return true;
    }
}
