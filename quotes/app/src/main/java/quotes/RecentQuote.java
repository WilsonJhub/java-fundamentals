package quotes;


import java.util.ArrayList;

public class RecentQuote {
    //properties
    ArrayList<String> tags;
    String author;
    String likes;
    String text;

    public RecentQuote(){
        //unassigned string, but we are initializing this ArrayList or tag property.
        this.tags = new ArrayList<>();
    }

    public RecentQuote(ArrayList<String> tags, String author, String likes, String text){
        // initialize a new object of this(RecentQuote) class. assigning expected values from the parameter list above^
        this.tags = tags;
        this.author = author;
        this.likes = likes;
        this.text = text;
    }
}
