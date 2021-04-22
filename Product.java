package onlineShop;
import java.time.LocalDate;

/**
 * a class to store details of a product
 *
 * @author Sepehr Noey
 */
public class Product {
    //product name
    private final String name;
    // category which this product is in it
    private final String category;
    // weight of the product in kilograms
    private final double weight;
    private final double price;
    private final LocalDate productDate;
    private final LocalDate expireDate;

    /**
     * constructor for product
     * @param name product name
     * @param category category which this product is in it
     * @param weight weight of the product in kilograms
     * @param price price considered for this product
     * @param daysToExpire specifies the days remaining to expire , it is used for making expireDate
     */
    public Product(String name , String category , double weight , double price , int daysToExpire){
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        productDate = LocalDate.now();
        expireDate = productDate.plusDays(daysToExpire);
    }

    /**
     * to access name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * to access category
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * to access weight of the product in kilograms
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * to access price
     * @return price of this product
     */
    public double getPrice() {
        return price;
    }

    /**
     * to access product date
     * @return productDate
     */
    public LocalDate getProductDate() {
        return productDate;
    }

    /**
     * to access expireDate
     * @return expireDate
     */
    public LocalDate getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return "{\n  \"Product\": {\n" + "    \"NAME\": \"" + name.substring(0,1).toUpperCase() + "\",\n"
                + "    \"CATEGORY\": \"" + category.substring(0,1).toUpperCase() + "\",\n" +
                String.format("    \"WEIGHT\": \"%.1f\",\n    \"PRICE\": \"%.1f\",",weight,price)
                + "    \"MANUFACTURE_DATE\": "+ productDate + ",\n" + "    \"EXPIRATION_DATE\": "+ expireDate + "\n  }\n}";
    }
}
