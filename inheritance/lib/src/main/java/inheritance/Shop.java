package inheritance;

public class Shop extends Business{


    public String description;


    public Shop (String name, String priceCategory, String description, int stars) {
        // super props are coming from the Super class Business
        super.name = name;
        super.priceCategory = priceCategory;
        super.stars = stars;
        this.description = description;
    }
    @Override
    public String toString() {

        return "Restaurant: " + name + " has a rating of " + stars + " and a price category of "
                + priceCategory + description;
    }
}

