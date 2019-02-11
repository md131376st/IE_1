import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;
import org.json.JSONTokener;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isFinished = false;
    static private ArrayList<Register> myusers = new ArrayList<>();
    static private ArrayList<Project> projects = new ArrayList<>();


    public static void main(String[] args) {
        while (!isFinished) {
            Pair<String, String> commandParts = getCommandParts();
            String commandName = commandParts.getKey();
            String commandData = commandParts.getValue();
            JSONObject object = jsonstring(commandData);

            switch (commandName) {
                case "register":
                    adduser(new Register(object));
                    break;
                case "addProject":
                    addproject(new Project(object));
                    break;
                case "bid":
                    addbid(commandData);
                    break;
                case "auction":
                    System.out.println(auction(commandData));
                    isFinished = true;
                    break;
            }
        }
    }

    private static Pair<String, String> getCommandParts() {
        String command = scanner.nextLine();
        int spaceIndex = command.indexOf(" ");
        return new Pair<>(command.substring(0, spaceIndex), command.substring(spaceIndex));
    }

    private static void adduser(Register newuser){
        int index = indexofstring(newuser.getUsername() , false);
        if(index == -1) {
            myusers.add(newuser);
        }
        else
            System.out.println("This User Has Registered Before");
    }

    private static void addproject(Project newproject){
        int index = indexofstring(newproject.getTitle() , true);
        if(index == -1) {
            projects.add(newproject);
        }
        else
            System.out.println("This Project Was Added Before");
    }

    private static JSONObject jsonstring(String commandData ){
        JSONTokener tokener = new JSONTokener(commandData);
        return new JSONObject(tokener);
    }

    private static boolean addbid(String commandData){
        JSONObject object = jsonstring(commandData);
        int index = indexofstring(object.getString("biddingUser"),false);
        int index1 = indexofstring(object.getString("projectTitle"),true);
        if (index!= -1 && index1!=-1) {
         return projects.get(index1).addreq(myusers.get(index),object);
        }
        else{
            if(index == -1){
                System.out.println("User Not Found");
            }
            else
                System.out.println("Project Not Found");
            return false;
        }
    }

    private static String auction(String commandData){
        JSONObject object = jsonstring(commandData);
        int index1 = indexofstring(object.getString("projectTitle"),true);
        if (index1 != -1)
        {
            return projects.get(index1).auction();
        }
        return "Project not Found";
    }

    private static int indexofstring(String comperstring , boolean flag){
        if (!flag){
            for (int i = 0 ; i<myusers.size(); i++ ){
                if(myusers.get(i).getUsername().equals(comperstring))
                    return i;
            }
            return -1;
        }
        else{
            for (int i=0; i<projects.size(); i++){
                if(projects.get(i).getTitle().equals(comperstring))
                    return i;
            }
            return -1;
        }
    }
}
