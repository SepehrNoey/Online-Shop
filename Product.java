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
     * @param weight weight of the product
     * @param price price considered for this product
     * @param manufactureDate sets date of manufacture , entered String should be in this format: year-month-day
     * @param expirationDate sets date of expiration , entered String should be in this format: year-month-day
     */
    public Product(String name , String category , double weight , double price , String manufactureDate , String expirationDate){
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        String[] manFac = manufactureDate.trim().split("-");
        String[] exp = expirationDate.trim().split("-");
        productDate = LocalDate.of(Integer.parseInt(manFac[0]) , Integer.parseInt(manFac[1]) , Integer.parseInt(manFac[2]));
        expireDate = LocalDate.of(Integer.parseInt(exp[0]) , Integer.parseInt(exp[1]) , Integer.parseInt(exp[2]));
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
