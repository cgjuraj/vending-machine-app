package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Item{

    public Candy(String position, String name, BigDecimal price, String description, int inventory) {
        super(position, name, price, description, inventory);
    }

    @Override
    public String getSound() {
        String message = "Sugar, Sugar, so Sweet!";
        return message;
    }
}
