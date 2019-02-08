import org.json.JSONObject;

public class Skills {
    private String name;
    private int points;

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    Skills(JSONObject object) {
        this.name = object.getString("name");
        this.points = object.getInt("points");
    }

}
