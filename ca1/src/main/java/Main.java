import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;



import java.io.InputStream;


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
//            System.out.println(tokener);

//            System.out.println("myname is mona");
//            System.out.println(object.getJSONArray("skills").get(0).getClass());
//            System.out.println("myname is mona");
            switch (commandName) {
                case "register":
                    adduser(new Register(object));
//                    System.out.println(myusers.get(myusers.lastIndexOf(myusers)).username);
                    System.out.println(commandData);
                    break;
                case "addProject":
                    addproject(new Project(object));
                    System.out.println(commandData);
                    break;
                case "bid":
                    addbid(commandData);
                    System.out.println(commandData);
                    break;
                case "auction":
                    System.out.println(commandData);
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
        myusers.add(newuser);
    }
    private static void addproject(Project newproject){
        projects.add(newproject);

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

        else return false;
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
