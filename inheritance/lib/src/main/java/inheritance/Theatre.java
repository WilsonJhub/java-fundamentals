package inheritance;

import java.util.ArrayList;

public class Theatre extends Business{

    // created an ArrayList that holds a String data type of movies from the class Theatre
    ArrayList<String> movies = new ArrayList<String>();

    public Theatre (String name){
        super.name = name;



    }
    public void addMoviesToArrayList(String movieName) {

        //allows us to add movies from ArrayList.
        movies.add(movieName);
    }

    public void removeMoviesFromArrayList(String movieName){
        //allows us to remove movies from ArrayList
        movies.remove(movieName);
    }
}
