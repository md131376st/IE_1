import sun.net.www.protocol.http.HttpURLConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

class MyHttpURLConnection {
    StringBuffer getContent() {
        return content;
    }

    private StringBuffer content ;

    MyHttpURLConnection(){
        this.content = new StringBuffer();
    }

    void get_url(String url) throws IOException {
        URL url_ = new URL(url);
        HttpURLConnection con = (HttpURLConnection)url_.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            this.content.append(inputLine);
        }
        in.close();
        con.disconnect();

    }


    public static void main(String[] args)throws Exception {
        MyHttpURLConnection hi = new MyHttpURLConnection();
        hi.get_url("http://142.93.134.194:8000/joboonja/project");
    }
}
