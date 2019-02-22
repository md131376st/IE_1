
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {
    private Projects myProjects;
    private ArrayList<Project> projects;
    private String projectsList = FindWantedProjects();
//    String projectsList = "";

    @Override
    public void HandleRequest(HttpExchange httpExchange) throws IOException {
        String response =
                "<html><title>Projects</title>"
                +"<body><h3>You can See Projects below</h3>"
                        +"<table style=width:100%>"
                        +"<tr>"
                            +"<th>id</th>"
                            +"<th>title</th>"
                            +"<th>description</th>"
                            +"<th>deadline</th>"
                            +"<th>budget</th>"
                        +"</tr>"
                        +projectsList
                +"</table>"
                +"</body>"
                + "</html>";

        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    public ProjectPage() {
        myProjects = Projects.getInstance();
        projects = Projects.getProjects();
    }

    private String FindWantedProjects() {
        MyUser myuser = MyUser.getInstance();
        StringBuilder list = new StringBuilder();
        String temp = "";
        int neededskills = 0 ;
        ArrayList<Skills> userskill = myuser.getMyusers_reg(0).getSkill();
        for (Project project : projects) {
            for (Skills anUserskill : userskill) {
                int index = project.findskil(anUserskill);
                if (index != -1) {
                    neededskills++;
                }
            }
            if (neededskills == userskill.size()) {
                temp = "<tr>"
                        + "<td>" + project.getId() + "</td>"
                        + "<td>" + project.getTitle() + "</td>"
                        + "<td>" + project.getDescription() + "</td>"
                        + "<td>" + project.getDeadline() + "</td>"
                        + "<td>" + project.getBudget() + "</td>"
                        + "</tr>";
            }
            list.append(temp);
        }
        return list.toString();
    }
    ////////////need to check the point for each project
}
