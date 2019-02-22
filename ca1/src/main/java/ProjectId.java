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
        boolean hasNeeded;
        String response;
        response = "";
        String[] path = httpExchange.getRequestURI().getPath().split("/");
        String id = path[3];
        hasNeeded = CheckAvailability(id);
        if(hasNeeded)
        {
            httpExchange.sendResponseHeaders(200, response.length());
        }

        else{
            response = "<html>"
                    + "<body><h2>You don't have enough requirement</body>"
                    + "</html>";
            httpExchange.sendResponseHeaders(403, response.length());
        }

        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    private boolean CheckAvailability(String id) {
        Projects myProjects = Projects.getInstance();
        Register myUser=MyUser.getInstance().getMyusers_reg(0);
        return myProjects.hasNecessarySkills(id,myUser);
    }

}