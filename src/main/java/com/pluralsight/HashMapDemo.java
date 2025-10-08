package com.pluralsight;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String, String> inventory = new HashMap<>();


        inventory.put("4567", "10' 2x4 (grade B) - $9.99");
        inventory.put("1234", "Hammer - $19.49");
        inventory.put("2345", "Box of nails - $9.29");
        inventory.put("9154", "9-in-1 Ratcheting Screwdriver - $24.97");
        inventory.put("1648", "10\" Crescent Wrench - $15.95");
        inventory.put("9876", "Mechanics Tool Set - $119.00");
        inventory.put("1212", "2\" Spring Clamp - $0.99");
        inventory.put("3434", "Large Trigger Clamps - $36.97");
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Store Inventory ===");

        boolean run = true;
        while (run) {
            System.out.print("\nEnter product ID to search: ");
            String id = scanner.nextLine().trim();

            if (inventory.containsKey(id)) {
                System.out.println("Found: " + inventory.get(id));
            } else {
                System.out.println("Product not found.");
            }
            System.out.print("\nWould you like to search again? (yes/no): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (!answer.equals("yes") && !answer.equals("y")) {
                run = false;
                System.out.println("\nGoodbye! Thanks for using the inventory system.");
            }
        }

        scanner.close();
    }


    }