package com.pluralsight;


import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;


        System.out.println("We carry the following inventory: ");


        for (int i = 0; i < inventory.size(); i++) {
            ;
            Product p = inventory.get(i);
            System.out.printf("id: %d %s - Price: $%.2f", p.getId(), p.getName(), p.getPrice());

            while (run) {

                System.out.println("\n=== Store Menu ===");
                System.out.println("1. Show all products");
                System.out.println("2. Find a product by ID");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");

                int choice = scanner.nextInt();
                System.out.println();

                switch (choice) {
                    case 1:
                        System.out.println("We carry the following inventory:\n");
                        for (Product p : inventory) {
                            System.out.printf("id: %d %s - Price: $%.2f%n",
                                    p.getId(), p.getName(), p.getPrice());
                        }
                        break;

                    case 2:
                        System.out.print("Enter product ID to search: ");
                        int searchId = scanner.nextInt();
                        Product found = getProduct(inventory, searchId);
                        if (found != null) {
                            System.out.printf("%d - %s - $%.2f%n",
                                    found.getId(), found.getName(), found.getPrice());
                        } else {
                            System.out.println("Product not found.");
                        }
                        break;

                    case 3:
                        System.out.println("Goodbye!");
                        run = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter 1–3.");
                }
            }
        }

        scanner.close();
    }



        public static ArrayList<Product> getInventory() {
            ArrayList<Product> inventory = new ArrayList<Product>();

            inventory.add(new Product(1234, "Perfume", 17.00f));
            inventory.add(new Product(4567, "Hammer", 18.00f));
            inventory.add(new Product(9876, "Mechanics Tool Set", 119.00f));
            inventory.add(new Product(1212, "2\" Spring Clamp", 0.99f));
            inventory.add(new Product(3434, "Large Trigger Clamps", 36.97f));


            return inventory;
        }
    }




        public static void printProduct (Product p){
            System.out.printf("%d - Name: %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
            public static Product getProduct (ArrayList < Product > inventory,int id){
                for (Product p : inventory) {
                    if (p.getId() == id) {
                        return p;
                    }
                }


                        return null;
                    }
                }




















