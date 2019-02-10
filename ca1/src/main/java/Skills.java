import org.json.JSONObject;

public class Skills {
    private String name;
    private int points;

    Skills(JSONObject object) {
        this.name = object.getString("name");
        this.points = object.getInt("points");
    }

    public String getName() {
        return name;
    }

    int getPoints() {
        return points;
    }

}
