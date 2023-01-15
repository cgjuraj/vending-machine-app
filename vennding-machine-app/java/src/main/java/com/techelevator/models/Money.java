package com.techelevator.models;

import java.math.BigDecimal;

public class Money {

    public String changeGiven(BigDecimal balance) {

        BigDecimal penny = new BigDecimal("0.01");
        BigDecimal nickel = new BigDecimal("0.05");
        BigDecimal dime = new BigDecimal("0.10");
        BigDecimal quarter = new BigDecimal("0.25");
        BigDecimal single = new BigDecimal("1.00");
        BigDecimal five = new BigDecimal("5.00");
        BigDecimal ten = new BigDecimal("10.00");

        BigDecimal numberOfPennies = new BigDecimal("0");
        BigDecimal numberOfNickels = new BigDecimal("0");
        BigDecimal numberOfDimes = new BigDecimal("0");
        BigDecimal numberOfQuarters = new BigDecimal("0");
        BigDecimal numberOfSingles = new BigDecimal("0");
        BigDecimal numberOfFives = new BigDecimal("0");
        BigDecimal numberOfTens = new BigDecimal("0");


        // the following if statements give the best possible change (least coins) starting with biggest coins
        // numberOfQuarters = balance / quarters (((how many times a quarter goes into the remaining balance)))
        // balance = balance % quarters (((if remaining balance isn't perfectly divisble by 25 then it moves on)))
        // no idea how to do this with BigDecimal

        if (balance.compareTo(ten) >= 0) {
            numberOfTens = balance.divide(ten);
            balance = balance.remainder(ten);
        }

        if (balance.compareTo(five) >= 0) {
            numberOfFives = balance.divide(five);
            balance = balance.remainder(five);
        }

        if (balance.compareTo(single) >= 0) {
            numberOfSingles = balance.divide(single);
            balance = balance.remainder(single);
        }

        if (balance.compareTo(quarter) >= 0) {
            numberOfQuarters = balance.divide(quarter);
            balance = balance.remainder(quarter);
        }

        if (balance.compareTo(dime) >= 0) {
            numberOfDimes = balance.divide(dime);
            balance = balance.remainder(dime);
        }

        if (balance.compareTo(nickel) >= 0) {
            numberOfNickels = balance.divide(nickel);
            balance = balance.remainder(nickel);
        }

        if (balance.compareTo(penny) >= 0) {
            numberOfPennies = balance.divide(penny);
            balance = balance.remainder(penny);
        }

        //make these values int
        return "Your change is: " + numberOfTens.intValue() + " tens, " + numberOfFives.intValue() + " fives, " + numberOfSingles.intValue() + " singles, " + numberOfQuarters.intValue() + " quarters, " + numberOfDimes.intValue() + " dimes, " + numberOfNickels.intValue() + " nickels, " + numberOfPennies.intValue() + " pennies.";

        // return "A String so coins returned is printed out as a message for the user (number 7 section iii in README)";
        // or make this entire method BigDecimal and a separate method to convert to string
    }
}
