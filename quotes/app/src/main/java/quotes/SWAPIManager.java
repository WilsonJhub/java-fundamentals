package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SWAPIManager {
    private final String STARWARS_URL = "http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";

    private Gson gson;

    public SWAPIManager(){
        this.gson = new Gson();
    }

    //  Creates request from the API using the URL.
    public HttpURLConnection createRequest() throws IOException {
        URL StarWarsURL = new URL(STARWARS_URL);
        HttpURLConnection StarWarsURLConnection = (HttpURLConnection) StarWarsURL.openConnection();
        StarWarsURLConnection.setRequestMethod("GET");
        return StarWarsURLConnection;
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

    //  Parses the response data into the StarWarsQuote schema, and returns.
    public StarWarsQuote parsedQuoteFromResponse(StringBuffer _content) {
        StarWarsQuote randomStarWarsQuote = gson.fromJson(String.valueOf(_content), StarWarsQuote.class);
        return randomStarWarsQuote;
    }

}
