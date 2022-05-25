package inheritance;

import java.util.ArrayList;

public class Business {


    public int stars;
    public String name;
    public String priceCategory;

    // created an ArrayList that holds reviews from the class Review
    ArrayList<Review> reviews = new ArrayList<>();

//    public Business (String name, String priceCategory, int stars){
//        this.name = name;
//        this.priceCategory = priceCategory;
//        this.stars = stars;
//    }

    protected void review(IReview review){
        System.out.println(review.get_author());
    }
}
