
import java.io.IOException;

import com.sun.net.httpserver.HttpExchange;

public interface Page {
    public void HandleRequest(HttpExchange httpExchange) throws IOException;
}
