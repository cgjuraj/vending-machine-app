package com.techelevator.models;

import java.math.BigDecimal;

public class FeedMoney {

    private BigDecimal balance = new BigDecimal("0");
    private BigDecimal aBuck = new BigDecimal("1");
    private BigDecimal aFiver = new BigDecimal("5");
    private BigDecimal aTenner = new BigDecimal("10");
    private BigDecimal aDub = new BigDecimal("20");

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal updatedBalance) {
        this.balance = updatedBalance;
    }

    // method to increase balance only if $1, $5, $10, $20 bills are given
    public boolean moneyIntoMachine(BigDecimal cashReceived) {
        if (cashReceived.equals(aBuck) || cashReceived.equals(aFiver) || cashReceived.equals(aTenner) || cashReceived.equals(aDub)) {
            balance = balance.add(cashReceived);
            return true;
        }
        return false;
    }
}
