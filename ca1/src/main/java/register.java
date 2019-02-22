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

    private void addSkills(Skills rskill){
        this.Skill.add(rskill);
    }

    public String getId() { return id;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getBio() {
        return bio;
    }
}
