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

    String getUsername() {
        return username;
    }

    ArrayList<Skills> getSkill() {
        return Skill;
    }
    int findSkill(String name){
        for (int i = 0 ; i < Skill.size() ; i++) {
            if(Skill.get(i).getName().equals(name))
                return i;

        }
        return -1;
    }
    private void addSkills(Skills rskill){
        this.Skill.add(rskill);
    }

    public String getId() { return id;}

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    String getJobTitle() {
        return jobTitle;
    }

    String getBio() {
        return bio;
    }
}
