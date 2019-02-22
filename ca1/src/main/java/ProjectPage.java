
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {
    Projects myProjects;
    ArrayList<Project> projects;
    String projectsList = FindWantedProjects();

    @Override
    public void HandleRequest(HttpExchange httpExchange) throws IOException {
        String response =
                "<html>"
                        + "<body><h1>You can see projects below111</h1></body>"
                        +""
                        + "</html>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    public ProjectPage() {
        myProjects = Projects.getInstance();
        projects = myProjects.getProjects();
    }

    private String FindWantedProjects() {
        String list = "";
        for(int i = 0 ; i < projects.size() ; i++)
        {
            
        }
        return list;
    }
}
