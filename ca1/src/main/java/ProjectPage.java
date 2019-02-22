
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {
    private Projects myProjects;
    private ArrayList<Project> projects;
    private String projectsList ;
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
//        byte[] hi = response.getBytes();
        httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.UTF_16).length);
        httpExchange.getResponseHeaders().set("Content-Type", "text/html");
//        httpExchange.getResponseHeaders().set("encoding", "utf_16");
        OutputStream os = httpExchange.getResponseBody();
//        System.out.println(response.getBytes(StandardCharsets.UTF_8).length);

//        System.out.println(hi.toString());

//        System.out.println(new String(hi));
        os.write(response.getBytes(StandardCharsets.UTF_16));

//
//        os.flush();
        os.close();
    }
    public ProjectPage() {
        myProjects = Projects.getInstance();

        projects = Projects.getProjects();
        projectsList = FindWantedProjects();
    }

    private String FindWantedProjects() {
        MyUser myuser = MyUser.getInstance();
        StringBuilder list = new StringBuilder();

        int neededskills = 0 ;
        ArrayList<Skills> userskill = myuser.getMyusers_reg(0).getSkill();
        for (Project project : projects) {
            String temp = "";
            for (Skills anUserskill : userskill) {
                int index = project.findskil(anUserskill);
                if (index != -1) {
                    neededskills++;
                }
//               else break;
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
}
