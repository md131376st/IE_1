package models;

public class Main {

    public static void main(String[] args)throws Exception {
        MyUser myUser=MyUser.getInstance();
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
