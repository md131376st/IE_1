import org.json.JSONObject;

import java.util.ArrayList;
import org.json.JSONArray;

class Register {
    private String id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private String profilePictureURL;
    private ArrayList<Skills> Skill;
    private String username;
    private String bio;

    Register(String id, String firstName, String lastName, String jobTitle, String profilePictureURL, ArrayList<Skills> skill, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.profilePictureURL = profilePictureURL;
        Skill = skill;
        this.bio = bio;
    }

//    Register() {
//        this.id = object.getString("id");
//        Skill = new ArrayList<>();
//         JSONArray myskills = object.getJSONArray("skills");
//        for (int i = 0 ; i < myskills.length(); i++){
//             Skills newskill = new Skills(myskills.getJSONObject(i));
//             addSkills(newskill);
//        }
//    }

    String getUsername() {
        return username;
    }

    ArrayList<Skills> getSkill() {
        return Skill;
    }

    private void addSkills(Skills rskill){
        this.Skill.add(rskill);
    }
}
