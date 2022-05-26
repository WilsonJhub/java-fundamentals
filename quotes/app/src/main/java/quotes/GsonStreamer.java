package quotes;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken<T>;

public class GsonStreamer {

    public ArrayList<RecentQuote> readInFile;
    public String fileName;

    public GsonStreamer(String fileName){
        this.fileName = fileName;
        readInFile = new ArrayList<RecentQuote>();
    }

    public boolean getFile() throws IOException {
        File recentQuote = new File(fileName);
        FileReader quoteFileReader = new FileReader(recentQuote);

        Gson gson = new Gson();

        Type quoteType = new TypeToken<ArrayList<RecentQuote>>(){}.getType();
        // ^^^ creating our own type/ gson expecting a reader and TypeToken ^^^
        ArrayList<RecentQuote> quoteArray = gson.fromJson(quoteFileReader, quoteType);
        readInFile.addAll(quoteArray);
        // here we're adding the contents of quoteArray into readInFile.

        return true;
    }

    public String getRandomQuote(){

        Random indexNum = new Random();
        int capacity = readInFile.size()-1;

        int randomIndex = indexNum.nextInt(0, capacity);
        RecentQuote selectedQuote = readInFile.get(randomIndex);//

        return selectedQuote.author + " " + selectedQuote.text;
    }
}
