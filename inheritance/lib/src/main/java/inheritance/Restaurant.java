package inheritance;

import java.util.ArrayList;
import java.util.HashSet;

public class Restaurant extends Business {
    public int stars;
    public String name;
    public String priceCategory;
    public HashSet<Review> restReviews;

//    public Restaurant() {
//        super(String, name);
//        this.priceCategory = "";
//        this.name = "";
//        this.stars = 0;
//        this.restReviews = new HashSet<Review>();
//    }

    public Restaurant (String priceCategory, String name, int stars) {
        super.name = name;
        super.priceCategory = priceCategory;
        super.stars = stars;


    }

    @Override
    public String toString() {
//        String reviewDescription = "number of reviews" + restReviews.size();
        return "Restaurant: " + name + " has a rating of " + stars + " and a price category of " + priceCategory;
    }

    public void addReview(Review aReview) {
        restReviews = new HashSet<>();
        restReviews.add(aReview);
    }

}
