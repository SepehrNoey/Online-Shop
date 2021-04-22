package onlineShop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Inventory inventory = new Inventory();
        // adding products
        Product carrot = new Product("Carrot","Vegetables", 5,20,"2020-3-15","2021-3-15");
        Product apple = new Product("Apple","Fruits", 10,50,"2020-4-1","2021-8-1");
        Product eggs = new Product("12xEggs","Egg", 100,40,"2020-1-1","2021-6-1");
        Product oats = new Product("Oats","Grains", 70,100,"2020-6-1","2021-1-1");
        Product salmon = new Product("Salmon","Seafood", 150,250,"2020-1-1","2020-2-1");
        Product stake = new Product("Stake","Meat", 800,1000,"2020-3-1","2020-9-1");
        Product milk = new Product("Milk","Dairy", 100,20,"2020-1-10","2020-1-25");
        Product cheese = new Product("Cheese","Dairy", 150,10,"2020-2-1","2020-3-15");

        // adding to inventory
        inventory.addProduct(carrot , 10);
        inventory.addProduct(apple , 50);
        inventory.addProduct(eggs , 20);
        inventory.addProduct(oats , 45);
        inventory.addProduct(salmon , 5);
        inventory.addProduct(stake , 5);
        inventory.addProduct(milk , 20);
        inventory.addProduct(cheese , 50);

        Basket basket = new Basket(inventory);
        System.out.println(inventory.toString());
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter commands(enter -1 for exit)");
            String command = scanner.nextLine();
            if (command.trim().equals("-1"))
                return;
            String[] inputs = command.trim().split(" ");
            if (inputs[0].equals("add"))
                basket.add(Integer.parseInt(inputs[1]));
            else if (inputs[0].equals("remove"))
                basket.remove(Integer.parseInt(inputs[1]));
            else if (inputs[0].equals("cart"))
                System.out.println(basket.toString());
            else if (inputs[0].equals("products"))
                System.out.println(inventory);
            else if (inputs[0].equals("checkout")){
                System.out.println("Invoice number: "  + basket.getInvoiceNumber());
                System.out.println("Total cost is: " + basket.getTotalCost() + "$");
                System.out.println("We pay it ourselves this time :)");
                basket.setPaid();
                System.out.println("It was a pleasure doing business with you.");
                break;
            }

        }

    }
}
