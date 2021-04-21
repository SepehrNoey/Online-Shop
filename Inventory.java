package onlineShop;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
        String name = scanner.nextLine().trim().toUpperCase();
        Product newOrExistingProduct = null;
        for (Product product:products.keySet())
            if (product.getName().equals(name))
                newOrExistingProduct = product;
        if (newOrExistingProduct != null) {
            System.out.println("This product already exists. If you want to add some , enter the number. Else enter -1 for exit");
            int numToAdd = scanner.nextInt();
            products.replace(newOrExistingProduct,numToAdd + products.get(newOrExistingProduct));
            System.out.println("Stock updated.");
        }
        else {
            System.out.println("Please enter category: ");
            String category = scanner.nextLine().trim().toUpperCase();
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
}
