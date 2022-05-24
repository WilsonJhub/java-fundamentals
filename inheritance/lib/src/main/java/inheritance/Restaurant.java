package inheritance;

import java.util.ArrayList;
import java.util.HashSet;

public class Restaurant {
    public int restStars;
    public String name;
    public String priceCategory;
    public HashSet<Review> restReviews;

    public Restaurant() {
        this.priceCategory = "";
        this.name = "";
        this.restStars = 0;
        this.restReviews = new HashSet<Review>();
    }

    public Restaurant (String priceCategory, String name, int restStars) {
        this.priceCategory = priceCategory;
        this.name = name;
        this.restStars = restStars;


    }

    @Override
    public String toString() {
//        String reviewDescription = "number of reviews" + restReviews.size();
        return "Restaurant: " + name + " has a rating of " + restStars + " and a price category of " + priceCategory;
    }

    public void addReview(Review aReview) {
        restReviews = new HashSet<>();
        restReviews.add(aReview);
    }

}
