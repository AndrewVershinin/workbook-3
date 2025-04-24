package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class SearchInventoryApp {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        createNewInventory(inventory);

//        System.out.println("Store Inventory:");
//        for (int i = 0; i < inventory.size(); i++) {
//            Product p = inventory.get(i);
////            System.out.printf("id: %d %s - Price: $%.2f\n", p.getId(), p.getName(), p.getPrice());
//            System.out.println(p);
//        }

    }

    public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<Product>();

//        inventory.add(new Product(1, "Black Paper", 2.5));
//        inventory.add(new Product(2, "Noodle soup", 6.5));
//        inventory.add(new Product(3, "Borscht", 8.5));
//        inventory.add(new Product(4, "Omlete", 5.5));
//        inventory.add(new Product(5, "Steak", 15.5));

        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                Product product = new Product(id, name, price);
                inventory.add(product);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }

    public static void createNewInventory(ArrayList<Product> inventory) {

        try {
            FileWriter fw = new FileWriter("src/main/resources/new_inventory.csv");
            BufferedWriter writer = new BufferedWriter(fw);

            for (int i = 0; i < inventory.size(); i++) {
                Product p = inventory.get(i);
                String line = String.format("%d|%s|%.2f", p.getId(), p.getName(), p.getPrice());
                writer.write(line);
                writer.newLine();
            }
          writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

