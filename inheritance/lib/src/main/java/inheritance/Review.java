package inheritance;

public class Review {
    public Restaurant eatery;
    public String body;
    public String author;
    public int stars;

    public  Review(String body, String author, int stars, Restaurant SaltGrass){
        this.body = body;
        this.author = author;
        this.stars = stars;
        this.eatery = SaltGrass;
    }

    @Override
    public String toString() {
        return eatery.name + " " + eatery.priceCategory + " reviewed by: " + author + " \n" + body + " \n";
    }
}
