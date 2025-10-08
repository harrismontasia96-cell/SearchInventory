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

    public static void printProduct(Product p) {
        System.out.printf("%d - Name: %s - Price: $%.2f%n",
                p.getId(), p.getName(), p.getPrice());
    }
}























