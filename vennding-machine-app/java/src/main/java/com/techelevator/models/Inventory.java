package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

    private File cateringList;
    private Map<String, Item> listOfItems = new HashMap<>();

    public Inventory(File cateringList) {
        this.cateringList = cateringList;
    }

    public void itemsList(File cateringList) {
        try (Scanner input = new Scanner(new File("catering.csv"))) {
            while (input.hasNextLine()) {
                String fullLine = input.nextLine();
                String[] fields = fullLine.split(",");
                int quantity = 6;

                if (fields[3].equalsIgnoreCase("Munchy")) {
                    BigDecimal priceBD = new BigDecimal(fields[2]);
                    Munchy newItem = new Munchy(fields[0], fields[1], priceBD, fields[3], quantity);
                    listOfItems.put(fields[0], newItem);
                }
                else if (fields[3].equalsIgnoreCase("Candy")) {
                    BigDecimal priceBD = new BigDecimal(fields[2]);
                    Candy newItem = new Candy(fields[0], fields[1], priceBD, fields[3], quantity);
                    listOfItems.put(fields[0], newItem);
                }
                else if (fields[3].equalsIgnoreCase("Drink")) {
                    BigDecimal priceBD = new BigDecimal(fields[2]);
                    Drink newItem = new Drink(fields[0], fields[1], priceBD, fields[3], quantity);
                    listOfItems.put(fields[0], newItem);
                }
                else if (fields[3].equalsIgnoreCase("Gum")) {
                    BigDecimal priceBD = new BigDecimal(fields[2]);
                    Gum newItem = new Gum(fields[0], fields[1], priceBD, fields[3], quantity);
                    listOfItems.put(fields[0], newItem);
            }
        }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
    }
    }

    public String displayAll() {
        String displayList = "";
        for(String currentItem : listOfItems.keySet()) {
            displayList = displayList + listOfItems.get(currentItem).getPosition() + " ";
            displayList = displayList + listOfItems.get(currentItem).getName() + " ";
            displayList = displayList + "$" + listOfItems.get(currentItem).getPrice() + " - ";
            int inventoryRemaining = listOfItems.get(currentItem).getInventory();
            String consoleQuantity = "";
            consoleQuantity += inventoryRemaining;
            displayList += "Remaining: ";
            displayList += consoleQuantity;
            displayList += "\n";
        }
        return displayList;
    }

    public Item getItem(String slot) {
        return listOfItems.get(slot);
    }

    public boolean inventoryEmpty (String slot) {
        if (listOfItems.get(slot).getInventory() > 0) {
            return false;
        }
        return true;
    }

    public boolean doesNotExist (String slot) {
        if(!listOfItems.containsKey(slot)) {
            return false;
        }
        return true;
    }



    // improve so the logic is done here so only the method needs printed in VendingMachine class
//    public String inventoryEmpty() {
//        String soldOut = "Item is sold out.";
//        return soldOut;
//    }
}

