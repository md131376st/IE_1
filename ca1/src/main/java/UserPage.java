import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.sun.net.httpserver.HttpExchange;

public class UserPage implements Page {
    String response = "";
    @Override
    public void HandleRequest(HttpExchange httpExchange) throws IOException {
        String[] path = httpExchange.getRequestURI().getPath().split("/");
        String id = path[3];

        Register user = MyUser.getInstance().FindUser(id);
        response = "<html><title>Project Info</title>"
                + "<body>"
                +"<ul>"
                +   "<li>id = " + user.getId() + "</li>"
                +   "<li>first name = " + user.getFirstName() + "</li>"
                +   "<li>last name = " + user.getLastName() + "</li>"
                +   "<li>job title = " + user.getJobTitle() + "</li>"
                +   "<li>bio = " + user.getBio() + "</li>"
                + "</ul> "
                +"</body>"
                + "</html>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}