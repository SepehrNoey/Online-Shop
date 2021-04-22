package onlineShop;

import java.util.HashMap;
import java.util.Scanner;

/**
 * simulates an stock(inventory)
 *
 * @author Sepehr Noey
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
    public void addProduct(Product product , int num){
        boolean isFound = false;
        for (Product productOflist:products.keySet())
            if (productOflist.getName().equals(product.getName())) // updating existing product
            {
                products.replace(product, num + products.get(product));
                isFound = true;
            }
        if (!isFound) // it's a new product
            products.put(product , num);
    }

    /**
     * it's a method to remove or subtract number of a product
     */
    public void removeProduct(){
        System.out.println("Please enter the name of product: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
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
     * overridden toString for inventory, contains details of all products in order
     */
    @Override
    public String toString(){
        if(products.size() == 0) {
            System.out.println("We are out of stock.");
            return null;
        }
        int i = 0;
        String string = "Here's the list of products we have: \n";
        for (Product product:products.keySet())
        {
            i++;
            string = string + i + ")" + product.toString() + "in stock: " + products.get(product) + "\n";
        }
        return string;
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
