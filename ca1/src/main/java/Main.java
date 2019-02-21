import javafx.util.Pair;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isFinished = false;


    public static void main(String[] args)throws Exception {
        MyUser myUser=MyUser.getInstance();
        Projects myProjects = Projects.getInstance();
        myUser.adduser(new Utility().getDefultUser());
        AllSkills incSkills = AllSkills.getInstance();
        incSkills.setUrl("http://142.93.134.194:8000/joboonja/skill");
        incSkills.setAllskills();
        myProjects.get_project_url("http://142.93.134.194:8000/joboonja/project");


//        ReflectionServer server = new ReflectionServer();
//        server.startServer();
//        while (!isFinished) {
//            Pair<String, String> commandParts = getCommandParts();
//            String commandName = commandParts.getKey();
//            String commandData = commandParts.getValue();
//            JSONObject object = jsonstring(commandData);
//
//            switch (commandName) {
//                case "register":
//                    myUser.adduser(new Register(object));
//                    break;
//                case "addProject":
//                    myProjects.addproject(new Project(object));
//                    break;
//                case "bid":
//                    myProjects.addbid(commandData, myUser);
//                    break;
//                case "auction":
//                    System.out.println(myProjects.auction(commandData));
//                    isFinished = true;
//                    break;
//            }
//        }

    }

    private static Pair<String, String> getCommandParts() {
        String command = scanner.nextLine();
        int spaceIndex = command.indexOf(" ");
        return new Pair<>(command.substring(0, spaceIndex), command.substring(spaceIndex));
    }


    private static JSONObject jsonstring(String commandData ){
        JSONTokener tokener = new JSONTokener(commandData);
        return new JSONObject(tokener);
    }

}
