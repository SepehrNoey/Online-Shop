package onlineShop;

import java.util.*;

/**
 * a class that simulates cart
 */
public class Basket {
    private HashMap<Product , Integer> myBasket;
    private double totalCost;
    private boolean isPaid;
    private final int invoiceNumber;
    private final Inventory inventory;

    /**
     * constructor - it generates an empty basket with a specific invoice number
     */
    public Basket(Inventory inventory){
        myBasket = new HashMap<>();
        totalCost = 0;
        isPaid = false;
        Random randomGenerator = new Random();
        invoiceNumber = randomGenerator.nextInt(30000) + 1;
        this.inventory = inventory;
    }

    /**
     * a method to add product to basket
     */
    public void add(int index){
        int i = 0;
        boolean isFound = false;
        for (Product product:inventory.getProducts().keySet())
        {
            i++;
            if (i == index && inventory.getProducts().get(product) > 0)
            {
                if (myBasket.containsKey(product))
                {
                    System.out.println("One more of this product added.");
                    myBasket.replace(product , myBasket.get(product) + 1);
                }
                else {
                    System.out.println("Product added to your basket.");
                    myBasket.put(product , 1);
                }
                isFound = true;
                inventory.updateStock(product , '-');
            }
        }
        if (!isFound)
            System.out.println("Sorry. Invalid index or not enough product in stock!");
    }

    /**
     * a method for removing or decreasing the number of some product in customer's basket
     * @param index is the index of product to remove
     */
    public void remove(int index){
        if (myBasket.size() == 0)
            System.out.println("List is empty.");
        int i = 0 ;
        boolean isFound = false;
        Product toRemove = null;
        for (Product product: myBasket.keySet())
        {
            i++;
            if (i == index && myBasket.get(product) > 0)
            {
                isFound = true;
                toRemove = product;
                break;

            }
        }
        if (!isFound)
            System.out.println("Sorry. Invalid index!");

        // now , checking how many of this product is in the basket

        else if (myBasket.get(toRemove) > 1){
            System.out.println("How many of this product do you want to give back?");
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            if (num < myBasket.get(toRemove)) {
                myBasket.replace(toRemove,myBasket.get(toRemove) - num);
                for (int j = 0 ; j < num ; j++)
                    inventory.updateStock(toRemove , '+');
            }
            else {
                myBasket.remove(toRemove);
                for (int j = 0 ; j < myBasket.get(toRemove) ; j++)
                    inventory.updateStock(toRemove,'+');
            }
            System.out.println("Product removed.");
        }

        // there is just one of this product in basket

        else {
            myBasket.remove(toRemove);
            System.out.println("Product removed.");
            inventory.updateStock(toRemove , '+');
        }
    }
}
