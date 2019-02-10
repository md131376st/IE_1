import org.json.JSONArray;
import org.json.JSONObject;

        import java.util.ArrayList;

public class Project {
    private String title;

    public String getTitle() {
        return title;
    }

    public ArrayList<Skills> getNeedskil() {
        return needskil;
    }

    private ArrayList<Skills> needskil;

    Project(JSONObject object) {
        this.title = object.getString("title");
        needskil = new ArrayList<>();
        JSONArray myskills = object.getJSONArray("skills");
        for (int i = 0 ; i < myskills.length(); i++){
            Skills newskill = new Skills(myskills.getJSONObject(i));
            addSkills(newskill);

        }
    }
    private void addSkills(Skills rskill){
        this.needskil.add(rskill);
    }
}
