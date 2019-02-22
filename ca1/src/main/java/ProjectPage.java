
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {
    Projects myProjects;
    ArrayList<Project> projects;
    String projectsList ;
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
        httpExchange.sendResponseHeaders(200, response.getBytes(StandardCharsets.US_ASCII).length);
        httpExchange.getResponseHeaders().set("Content-Type", "text/html");
        OutputStream os = httpExchange.getResponseBody();
//        System.out.println(response.getBytes(StandardCharsets.UTF_8).length);

//        System.out.println(hi.toString());

//        System.out.println(new String(hi));
        os.write(response.getBytes(StandardCharsets.US_ASCII));

//
//        os.flush();
        os.close();
    }
    public ProjectPage() {
        myProjects = Projects.getInstance();

        projects = myProjects.getProjects();
        projectsList = FindWantedProjects();
    }

    public String FindWantedProjects() {
//        new ProjectPage();
        MyUser myuser = MyUser.getInstance();
        StringBuilder list = new StringBuilder();

        int neededskills = 0 ;
        ArrayList<Skills> userskill = myuser.getMyusers_reg(0).getSkill();
        for(int i = 0 ; i < projects.size() ; i++)
        {
            String temp = "";
           for(int j = 0 ; j<userskill.size();j++) {
               int index = projects.get(i).findskil(userskill.get(j));
               if(index != -1){
                   neededskills++;
               }
//               else break;
           }
           if(neededskills == userskill.size()){
                        temp ="<tr>"
                                +"<td>"+ projects.get(i).getId() +"</td>"
                                +"<td>"+projects.get(i).getTitle()+"</td>"
                                +"<td>"+projects.get(i).getDescription()+"</td>"
                                +"<td>"+projects.get(i).getDeadline()+"</td>"
                                +"<td>"+projects.get(i).getBudget()+"</td>"
                            +"</tr>";
           }
           list.append(temp);
        }
        return list.toString();
    }
}
