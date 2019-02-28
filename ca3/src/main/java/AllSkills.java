import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

class AllSkills {
    private static AllSkills ourInstance = new AllSkills();
    private static ArrayList<Skills> allskills = new ArrayList<>();
    private static String url ;

    void setAllskills() {
        MyHttpURLConnection get_skills = new MyHttpURLConnection();
        try {
            get_skills.get_url(url);
            allskills = new Utility().getskilsnames( new Utility().jsonbufferstring(get_skills.getContent()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    void setUrl(String url) {
        AllSkills.url = url;
    }
    static AllSkills getInstance() {
        return ourInstance;
    }

    private AllSkills() {
    }

}
