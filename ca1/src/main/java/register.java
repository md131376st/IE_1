import org.json.JSONObject;

import java.util.ArrayList;
import org.json.JSONArray;

public class Register {
    public ArrayList<Skills> getSkill() {
        return Skill;
    }

    private ArrayList<Skills> Skill;

    public String getUsername() {
        return username;
    }

    private String username;
    Register(JSONObject object) {
        this.username = object.getString("username");
//        System.out.println(this.username);
        Skill = new ArrayList<>();
         JSONArray myskills = object.getJSONArray("skills");
        for (int i = 0 ; i < myskills.length(); i++){
             Skills newskill = new Skills(myskills.getJSONObject(i));
             addSkills(newskill);

        }


    }
    private void addSkills(Skills rskill){
        this.Skill.add(rskill);
    }
}
