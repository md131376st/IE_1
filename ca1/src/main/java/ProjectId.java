import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectId implements Page {
    Projects myProjects;
    ArrayList<Project> projects;
    //    String projectsList = FindWantedProjects();
    String projectsList = "";

    @Override
    public void HandleRequest(HttpExchange httpExchange) throws IOException {
        String response ="";

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}