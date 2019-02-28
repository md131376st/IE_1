package models;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class Projects {
    private static Projects ourInstance = new Projects();
    static private ArrayList<Project> projects = new ArrayList<>();

    public static Projects getInstance() {
        return ourInstance;
    }

    public static ArrayList<Project> getProjects(){
        return projects;
    }
    private Projects() {
    }

    private static int indexofstring(String comperstring){
            for (int i=0; i<projects.size(); i++){
                if(projects.get(i).getTitle().equals(comperstring))
                    return i;
            }
            return -1;

    }
    public static int getProjectIndexByID(String id){
        for (int i = 0 ; i < projects.size() ; i++)
        {
            if(projects.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    public boolean hasNecessarySkills(String  id , Register user){
        boolean projectFound = false;
        boolean enoughSkill = true;
        int index = 0;
        for (int i = 0 ; i < projects.size() ; i++)
        {
            if(projects.get(i).getId().equals(id)){
                projectFound = true;
                index = i;
                break;
            }
        }
        if(projectFound)
        {
            for (Skills temp : projects.get(index).getNeedskil()) {
                int skillIndex =  user.findSkill(temp.getName());
                if(skillIndex != -1) {
                    if (temp.getPoints() > user.getSkill().get(skillIndex ).getPoints())
                        enoughSkill = false;


                }
                else {
                    enoughSkill = false;
                }
            }
            return enoughSkill;
        }
        return false;

    }
    public void get_project_url(String url){
        MyHttpURLConnection get_projects = new MyHttpURLConnection();
        try {
            get_projects.get_url(url);
            projects =new Utility().getprject(new Utility().jsonbufferstring(get_projects.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void addproject(Project newproject){
        int index = indexofstring(newproject.getTitle());
        if(index == -1) {
            projects.add(newproject);
        }
        else
            System.out.println("This models.Project Was Added Before");
    }

    boolean addbid(String commandData, MyUser myUser){
        JSONObject object = new Utility().jsonstring(commandData);
        int index = myUser.indexofstring(object.getString("biddingUser"));
        int index1 = indexofstring(object.getString("projectTitle"));
        if (index!= -1 && index1!=-1) {
            return projects.get(index1).addreq(myUser.getMyusers_reg(index),object);
        }
        else{
            if(index == -1){
                System.out.println("User Not Found");
            }
            else
                System.out.println("models.Project Not Found");
            return false;
        }
    }
    String auction(String commandData){
        JSONObject object = new Utility().jsonstring(commandData);
        int index1 = indexofstring(object.getString("projectTitle"));
        if (index1 != -1)
        {
            return projects.get(index1).auction();
        }
        return "models.Project not Found";

    }
}
