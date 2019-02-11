import org.json.JSONArray;
import org.json.JSONObject;
import java.lang.Math;

        import java.util.ArrayList;

public class Project {
    private String title;
    private ArrayList<Skills> needskil;
    private int budget;
    private ArrayList<ReqUser> userREQ;

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

    private int getBudget() {
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
                int skillplace = findskill(newuser, aNeedskil);
                if (skillplace != -1) {
                    if (newuser.getSkill().get(skillplace).getPoints() < aNeedskil.getPoints())
                        return false;
                }
                else return false;
            }
            this.userREQ.add(new ReqUser(newuser,object.getInt("bidAmount") ));
        }
     return true;
    }

    private int findskill(Register newuser, Skills aNeedskil){
        for (int i = 0; i<newuser.getSkill().size(); i++){
            if(newuser.getSkill().get(i).getName().equals(aNeedskil.getName()))
                return i;
        }
        return -1;
    }

    private int findskil(Skills userskil){
        for (int i=0; i<this.needskil.size(); i++){
            if(needskil.get(i).getName().equals(userskil.getName()))
                return i;
        }
        return -1;
    }
    String auction(){
        int max = 0;

        String winner ="";
        for (ReqUser anUserREQ : userREQ) {
            int score = 0;
            ArrayList<Skills> userskils = anUserREQ.getUserREQ().getSkill();
            for (Skills userskil : userskils) {

                int skillindex = findskil(userskil);
                if (skillindex != -1)
                    score += Math.pow(userskil.getPoints() - this.needskil.get(skillindex).getPoints(), 2) * 1000;
//              else score += Math.pow(userskil.getPoints(), 2) * 1000;
            }
            score += this.getBudget() - anUserREQ.getBidAmount();

            if (score > max) {
                max = score;
                winner = anUserREQ.getUserREQ().getUsername();
            }
        }
      return "winner: "+winner;
    }
}
