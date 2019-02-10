import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;



import java.io.InputStream;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean isFinished = false;
    static private ArrayList<Register> myusers = new ArrayList<>();


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
                    System.out.println(commandData);
                    break;
                case "bid":
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
    private static JSONObject jsonstring(String commandData ){
        JSONTokener tokener = new JSONTokener(commandData);
        JSONObject object = new JSONObject(tokener);
        return object;
    }
}
