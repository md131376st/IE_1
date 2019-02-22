import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args)throws Exception {
        MyUser myUser=MyUser.getInstance();
        myUser.addTempUser();
        Projects myProjects = Projects.getInstance();
        myUser.adduser(new Utility().getDefultUser());
        AllSkills incSkills = AllSkills.getInstance();
        incSkills.setUrl("http://142.93.134.194:8000/joboonja/skill");
        incSkills.setAllskills();
        myProjects.get_project_url("http://142.93.134.194:8000/joboonja/project");

        ReflectionServer server = new ReflectionServer();
        server.startServer();
    }
}
