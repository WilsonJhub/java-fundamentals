package quotes;

import java.io.IOException;
import java.net.HttpURLConnection;

public class GetMeAQuote {

    String fileName;

    public GetMeAQuote(){
        this.fileName = "";
    }
    public GetMeAQuote(String fileName_and_path){
        this.fileName = fileName_and_path;
    }
    public String getTheQuotes() throws IOException {
        String result = "";
        if(this.fileName == ""){
//            call Forismaticmanager to attempt to get an API quote.
            ForismaticManager forismaticManager = new ForismaticManager();
            try {
                HttpURLConnection ForismaticConnection = forismaticManager.createRequest();
                StringBuffer ForismaticBuffer = forismaticManager.readResponse(ForismaticConnection);
                Forismatic ForismaticParser = forismaticManager.parsedQuoteFromResponse(ForismaticBuffer);
                result = ForismaticParser.quoteAuthor + " " + ForismaticParser.quoteText;
            }
            catch (Exception ex){
            result = getGsonString();
            }
        } else {
            result = getGsonString();
        }
        return result;
    }

    private String getGsonString() throws IOException {
        String result;
        //            call GsonStreamer to load a local random quote.
        GsonStreamer gsonStreamer = new GsonStreamer(fileName);
        Boolean gotFile = gsonStreamer.getFile();
        String randomQuote = gsonStreamer.getRandomQuote();
        result = randomQuote;
        return result;
    }
}
