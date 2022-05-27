package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForismaticManager {
    private final String FORISMATIC_URL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";

    private Gson gson;

    public ForismaticManager(){
        this.gson = new Gson();
    }

    //  Creates request from the API using the URL.
    public HttpURLConnection createRequest() throws IOException {
        URL ForismaticURL = new URL(FORISMATIC_URL);
        HttpURLConnection ForismaticURLConnection = (HttpURLConnection) ForismaticURL.openConnection();
        ForismaticURLConnection.setRequestMethod("GET");
        System.out.println(ForismaticURLConnection.getResponseMessage());

        return ForismaticURLConnection;
    }

    //  Reads response of Httpconnection and returns stringbuffer.
    public StringBuffer readResponse(HttpURLConnection _connection) throws IOException {
        StringBuffer content = new StringBuffer();
        try (BufferedReader responseReader = new BufferedReader(new InputStreamReader(_connection.getInputStream()))) {
            String inputLine;
            while ((inputLine = responseReader.readLine()) != null) {
                content.append(inputLine);
            }
        }
        return content;
    }

    //  Parses the response data into the Forismatic API schema, and returns.
    public Forismatic parsedQuoteFromResponse(StringBuffer _content) {
        Forismatic randomForismatic = gson.fromJson(String.valueOf(_content), Forismatic.class);
        return randomForismatic;
    }

}
