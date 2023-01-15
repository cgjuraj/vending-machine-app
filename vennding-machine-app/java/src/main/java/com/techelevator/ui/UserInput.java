package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput
{
    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption()
    {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if (option.equalsIgnoreCase("D"))
        {
            return "display";
        }
        else if (option.equalsIgnoreCase("P"))
        {
            return "purchase";
        }
        else if (option.equalsIgnoreCase("E"))
        {
            return "exit";
        }
        else
        {
            return "";
        }

    }

    public static String getPurchaseScreenOption() {

        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim();

        if (option.equalsIgnoreCase("M"))
        {
            return "feed money";
        }
        else if (option.equalsIgnoreCase("S"))
        {
            return "select item";
        }
        else if (option.equalsIgnoreCase("F"))
        {
            return "finish transaction";
        }
        else
        {
            return "";
        }

    }

    //create method for addMoreMoney YEA/NAY

    
}
