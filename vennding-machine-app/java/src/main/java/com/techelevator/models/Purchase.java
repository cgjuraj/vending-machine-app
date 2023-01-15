package com.techelevator.models;

import java.math.BigDecimal;

public class Purchase {

    public Purchase() {
    }

    public String dispenseItem(Inventory currentInventory, String slot, FeedMoney currentBalance) {
        String orderDetails = "";
        String costString = String.valueOf(currentInventory.getItem(slot).getPrice());
        BigDecimal cost = new BigDecimal(costString);
        currentBalance.setBalance(currentBalance.getBalance().subtract(cost));
        orderDetails = orderDetails + currentInventory.getItem(slot).getName() + ", Price: $" + currentInventory.getItem(slot).getPrice() + ", Remaining Balance: $" + currentBalance.getBalance() + currentInventory.getItem(slot).getSound();
        return orderDetails;

    }
}
