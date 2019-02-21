
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;

public class ProjectPage implements Page {

    @Override
    public void HandleRequest(HttpExchange httpExchange) throws IOException {
        String response =
                "<html>"
                        + "<body><h1>You can see projects below111</h1></body>"
                        + "</html>";
        httpExchange.sendResponseHeaders(200, response.length());
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

}
