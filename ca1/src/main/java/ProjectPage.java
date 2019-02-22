
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
                "<html><title>Projects</title><style>"
                +"table {text-align: center;margin: 0 auto;}"
                +"td {min-width: 300px;margin: 5px 5px 5px 5px;text-align: center;}"
                + "</style><body><h3>"
                +"<table><tr><th>id</th>"
                + projectsList
                +"</h3></body>"
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
        String list = "idtitlebudget";
//        for(int i = 0 ; i < projects.size() ; i++)
//        {
//            list+="\t"
//        }
        return list;
    }
}
