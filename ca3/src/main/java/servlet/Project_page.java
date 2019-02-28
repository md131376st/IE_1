package servlet;

import models.MyUser;
import models.Project;
import models.Projects;
import models.Register;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static models.Projects.getProjects;

@WebServlet("/project/*")
public class Project_page extends MyServlet{
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        boolean hasNeeded;
        String[] path = request.getRequestURI().split("/");
        String id = path[3];
        hasNeeded = CheckAvailability(id);
        if(hasNeeded){
            Project selected = getProjects().get(Projects.getProjectIndexByID(id));

        }
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Hellosld!</h3>");

    }
    private boolean CheckAvailability(String id) {
        Projects myProjects = Projects.getInstance();
        Register myUser= MyUser.getInstance().getMyusers_reg(0);
        return myProjects.hasNecessarySkills(id,myUser);
    }

}
