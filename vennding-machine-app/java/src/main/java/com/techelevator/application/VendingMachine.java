package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine {

    public void run() {

        Scanner userInput = new Scanner(System.in);
        File cateringList = new File("catering.csv");
        Inventory inventory = new Inventory(cateringList);
        inventory.itemsList(cateringList);


        while (true) {

            while (true) {
                UserOutput.displayHomeScreen();
                String choice = UserInput.getHomeScreenOption();

                if (choice.equalsIgnoreCase("display")) {
                    System.out.println(inventory.displayAll());
                    continue;
                } else if (choice.equalsIgnoreCase("exit")) {
                    userInput.close();
                } else if (choice.equalsIgnoreCase("purchase")) {
                    break;
                } else {
                    System.out.println("Invalid selection - try again.");
                    continue;
                }
            }

            FeedMoney feedMoney = new FeedMoney();

            while (true) {
                UserOutput.displayPurchaseOptions();
                String choice = UserInput.getPurchaseScreenOption();

                Purchase purchase = new Purchase();

                if (!(choice.equalsIgnoreCase("feed money") || choice.equalsIgnoreCase("select item") || choice.equalsIgnoreCase("exit"))) {
                    System.out.println("Invalid selection - try M, S, or E.");
                    continue;

                } if (choice.equalsIgnoreCase("feed money")) {

                    while (true) {
                        System.out.println("How much money would you like to feed me? Accepts $1, $5, $10, and $20 bills.");
                        String cashReceived = userInput.nextLine();
                        BigDecimal cashBigDecimal = new BigDecimal(cashReceived);
                        boolean correctCash = feedMoney.moneyIntoMachine(cashBigDecimal);

                        if (!correctCash) {
                            System.out.println("Money returned. Please enter a $1, $5, $10, or $20 bill.");
                            continue;
                        }

                        System.out.println("Want to add more cash? YEA/NAY");
                        String moreMoney = userInput.nextLine();

                        if (moreMoney.equalsIgnoreCase("yea")) {
                            continue;
                        } else if (moreMoney.equalsIgnoreCase("nay")) {
                            break;
                        } else {
                            System.out.println("Invalid selection - try typing YEA or NAY.");
                        }

                    }
                    continue;

                }
                if (choice.equalsIgnoreCase("select item")) {

                    System.out.println("Please enter the item location number: ");
                    String itemChoice = userInput.nextLine();

                    if (!inventory.doesNotExist(itemChoice)) {
                        System.out.println("Product does not exist - try again.");
                        continue;
                    }

                    if (inventory.doesNotExist(itemChoice)) {
                        if (inventory.inventoryEmpty(itemChoice)) {
                            System.out.println("This item is out of stock. Choose another item or get your money back.");
                            continue;
                        }
                    }

                    BigDecimal enoughForItem = inventory.getItem(itemChoice).getPrice();

                    if (feedMoney.getBalance().compareTo(enoughForItem) >= 0) {
                        System.out.println(purchase.dispenseItem(inventory, itemChoice, feedMoney));
                        inventory.getItem(itemChoice).itemPurchased(); //remove 1 from inventory
                    } else {
                        System.out.println("Not enough money - add more or finish.");
                        continue;
                    }
                }
                if (choice.equalsIgnoreCase("finish transaction")) {
                    Money change = new Money();
                    System.out.println(change.changeGiven(feedMoney.getBalance()));
                    System.out.println("Bye bye.");
                    userInput.close();
                }
                break;

            }

            continue;

        }

    }

}
