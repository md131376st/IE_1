import org.json.JSONObject;
import org.json.JSONTokener;

class Utility {

    Utility() {
    }

    JSONObject jsonstring(String commandData){
        JSONTokener tokener = new JSONTokener(commandData);
        return new JSONObject(tokener);
    }
}
