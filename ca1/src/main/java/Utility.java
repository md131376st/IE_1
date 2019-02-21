import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

class Utility {

    Utility() {
    }

    JSONObject jsonstring(String commandData){
        JSONTokener tokener = new JSONTokener(commandData);
        return new JSONObject(tokener);
    }
    ArrayList<JSONObject> jsonbufferstring( StringBuffer commandData){
        ArrayList<JSONObject> jsonobjects = new ArrayList<>();
        JSONArray arr = new JSONArray(commandData.toString());
        for (int i=0; i<arr.length() ; i++){
            jsonobjects.add(arr.getJSONObject(i));
        }
        return jsonobjects;
    }
    @SuppressWarnings("unchecked")
    Register getDefultUser()throws FileNotFoundException {
        JSONTokener tokener = new JSONTokener(new FileReader("/Users/md/Desktop/collage/IE/CA1/SampleCode/ca1/defultuser.json"));
        JSONObject object = new JSONObject(tokener);
        ArrayList <Object> info = jsonparser(new ArrayList<>(Arrays.asList("id", "firstName", "lastName", "jobTitle", "profilePictureURL", "skills", "bio")),object);
        return new Register((String)info.get(0),(String)info.get(1),(String)info.get(2),(String)info.get(3),(String)info.get(4),(ArrayList<Skills>)info.get(5),(String)info.get(6));
    }

    private ArrayList<Object> jsonparser(ArrayList<String> data, JSONObject object)throws JSONException {
            ArrayList<Object> resultdata = new ArrayList<>();
            for (String aData : data) {
                switch (aData) {
                    case "skills":
                        resultdata.add(getskillsarrya(object));
                        break;
                    case "point":
                    case "bidAmount":
                    case "budget":
                        resultdata.add(object.getInt(aData));
                        break;
                    case "deadline":
                        resultdata.add(object.getLong(aData));
                        break;
                    default:
                        try {
                            resultdata.add(object.getString(aData));
                        } catch (JSONException e) {
                            resultdata.add(null);
                        }
                        break;
                }
        }
        return resultdata;
    }

    private ArrayList<Skills> getskillsarrya(JSONObject object) {
        ArrayList<Skills> skills = new ArrayList<>();
        JSONArray myskills = object.getJSONArray("skills");
        for (int i = 0; i < myskills.length(); i++) {
            skills.add(new Skills(myskills.getJSONObject(i)));
        }
        return skills;
    }

    ArrayList<Skills> getskilsnames(ArrayList<JSONObject> nameskils){
        ArrayList<Skills> skills = new ArrayList<>();
//        JSONArray nameskills = object.getJSONArray("");
        for (JSONObject nameskil : nameskils) {
            skills.add(new Skills(nameskil.getString("name"), 0));
        }
        return skills;
    }


}
