package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        System.out.println("We carry the following inventory:\n");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(), p.getName(), p.getPrice());
        }

        while (run) {

            System.out.println("\n=== Store Menu ===");
            System.out.println("1. Show all products");
            System.out.println("2. Find a product by ID");
            System.out.println("3. Exit");
            System.out.println("4. Add a new product");
            System.out.println("5. Search products by name");
            System.out.println("6. Search products by price");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a number between 1–6.");
                scanner.nextLine();
                continue;
            }


            int choice = scanner.nextInt();
            scanner.nextLine();
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

                case 4:
                    addNewProduct(inventory, scanner);
                    break;

                case 5:
                    searchByName(inventory, scanner);
                    break;

                case 6:
                    searchByPrice(inventory, scanner);
                    break;


            }
        }
        scanner.close();
    }


    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

        inventory.add(new Product(1434, "Perfume", 18.00f));
        inventory.add(new Product(4597, "BarbieDoll", 8.00f));
        inventory.add(new Product(9176, "AppleTree", 219.00f));
        inventory.add(new Product(2212, "2\" Spring Tent", 9.99f));
        inventory.add(new Product(3536, "Large Frogs", 46.97f));


        try (
                FileReader fileReader = new FileReader("src/main/resources/inventory.txt");
                BufferedReader bufReader = new BufferedReader(fileReader)
        ) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // skip blank lines

                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                float price = Float.parseFloat(parts[2]);

                inventory.add(new Product(id, name, price));
            }

        } catch (IOException e) {
            System.out.println("Error reading inventory file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number in inventory file: " + e.getMessage());
        }

        return inventory;
    }

    public static Product getProduct(ArrayList<Product> inventory, int id) {
        for (Product p : inventory) {
            if (p.getId() == id) {
                return p;
            }
        }

        return null;
    }

public static void addNewProduct(ArrayList<Product> inventory, Scanner scanner) {
    System.out.print("Enter new product ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter product name: ");
    String name = scanner.nextLine();

    System.out.print("Enter product price: ");
    float price = scanner.nextFloat();

    inventory.add(new Product(id, name, price));
    System.out.println("Product added successfully!");
}
public static void searchByName(ArrayList<Product> inventory, Scanner scanner) {
    System.out.print("Enter product name (or part of it): ");
    String searchTerm = scanner.nextLine().toLowerCase();

    boolean found = false;
    for (Product p : inventory) {
        if (p.getName().toLowerCase().contains(searchTerm)) {
            System.out.printf("%d - %s - $%.2f%n", p.getId(), p.getName(), p.getPrice());
            found = true;
        }
        }
    if (!found) {
        System.out.println("Product not found.");
    }
    }

        public static void searchByPrice (ArrayList < Product > inventory, Scanner scanner){
            System.out.print("Enter minimum price: ");
            float min = scanner.nextFloat();
            System.out.print("Enter maximum price: ");
            float max = scanner.nextFloat();

            boolean found = false;
            System.out.println("\nProducts within your price range:");
            for (Product p : inventory) {
                if (p.getPrice() >= min && p.getPrice() <= max) {
                    System.out.printf("%d - %s - $%.2f%n", p.getId(), p.getName(), p.getPrice());
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No products found within that price range.");
            }
        }
        public static void printProduct (Product p){
            System.out.printf("%d - Name: %s - Price: $%.2f%n",
                    p.getId(), p.getName(), p.getPrice());
        }
    }


























