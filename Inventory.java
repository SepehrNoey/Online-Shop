package onlineShop;

import java.util.HashMap;
import java.util.Scanner;

/**
 * simulates an stock(inventory)
 */
public class Inventory {
    private HashMap<Product,Integer> products;

    /**
     * constructor
     */
    public Inventory(){
        products = new HashMap<>();
    }

    /**
     * is a method to add new products or updating existing products
     */
    public void addProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter product name: ");
        String name = scanner.nextLine().trim().toLowerCase();
        Product newOrExistingProduct = null;
        for (Product product:products.keySet())
            if (product.getName().equals(name))
                newOrExistingProduct = product;
        if (newOrExistingProduct != null) {
            System.out.println("This product already exists. If you want to update the stock ," +
                    " enter the number (positive or negative) , else enter 0 for exit");
            int numToAdd = scanner.nextInt();
            if (numToAdd == 0)
                return;
            products.replace(newOrExistingProduct,numToAdd + products.get(newOrExistingProduct));
            System.out.println("Stock updated.");
        }
        else {
            System.out.println("Please enter category: ");
            String category = scanner.nextLine().trim().toLowerCase();
            System.out.println("Please enter weight: ");
            double weight = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("Please enter price: ");
            double price = Double.parseDouble(scanner.nextLine().trim());
            System.out.println("How much time does it take to expire?(in days)");
            int days = scanner.nextInt();
            System.out.println("How many of this product you want to add?");
            int num = scanner.nextInt();
            newOrExistingProduct = new Product(name,category,weight,price,days);
            products.put(newOrExistingProduct,num);
            System.out.println("New product added.");
        }
    }

    /**
     * it's a method to remove or subtract number of a product
     */
    public void removeProduct(){
        System.out.println("Please enter the name of product: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine().trim().toLowerCase();
        for (Product product:products.keySet()) {
            if (product.getName().equals(name)){
                System.out.println("Found in stock.");
                System.out.println( "In stock: "+ products.get(product));
                System.out.println("Enter the number you want to remove (all or some): ");
                int num = scanner.nextInt();
                if (num < products.get(product)){
                    products.replace(product, products.get(product) - num);
                    System.out.println("Done.");
                }
                else {
                    products.remove(product);
                    System.out.println("Done.");
                }
            }
        }
    }

    /**
     * a method to list products and their price
     */
    public void printStock(){
        int i = 0;
        System.out.println("Here's the list of products we have: ");
        for (Product product:products.keySet())
        {
            i++;
            System.out.println(i  + ")" + "{");
            System.out.println("  \"Product\": {");
            System.out.println("    \"NAME\": \"" + product.getName().substring(0,1).toUpperCase() + "\",");
            System.out.println("    \"CATEGORY\": \"" + product.getCategory().substring(0,1).toUpperCase() + "\",");
            System.out.printf("    \"WEIGHT\": \"%.1f\",",product.getWeight());
            System.out.printf("    \"PRICE\": \"%.1f\",",product.getPrice());
            System.out.println("    \"MANUFACTURE_DATE\": "+ product.getProductDate() + ",");
            System.out.println("    \"EXPIRATION_DATE\": "+ product.getExpireDate());
            System.out.println("  }\n}in stock: " + products.get(product));
        }
    }

    /**
     * to access products in Basket
     * @return products and number of them in stock
     */
    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    /**
     * a method to update stock when a product is added to or removed from a basket
     * @param product is the product we are working on
     * @param plusOrMinus if costumer buys some , then it should be '-' (minus), else it should be '+' (plus)
     */
    public void updateStock(Product product , char plusOrMinus){
        if (plusOrMinus == '+')
            products.replace(product,products.get(product) + 1);
        else
            products.replace(product,products.get(product) - 1);
    }
}
