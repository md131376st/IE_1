
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {
    Projects myProjects;
    ArrayList<Project> projects;
//    String projectsList = FindWantedProjects();
    String projectsList = "";

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
        projects = myProjects.getProjects();
    }

    public String FindWantedProjects() {
        MyUser myuser = MyUser.getInstance();
        String list = "";
        String temp = "";
        int neededskills = 0 ;
        ArrayList<Skills> userskill = myuser.getMyusers_reg(0).getSkill();
        for(int i = 0 ; i < projects.size() ; i++)
        {
           for(int j = 0 ; j<userskill.size();j++) {
               int index = projects.get(i).findskil(userskill.get(j));
               if(index != -1){
                   neededskills++;
               }
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
           list+=temp;
        }
        return list;
    }
}
