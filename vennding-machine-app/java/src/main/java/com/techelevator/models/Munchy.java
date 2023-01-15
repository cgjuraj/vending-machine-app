package com.techelevator.models;

import java.math.BigDecimal;

public class Munchy extends Item{

    public Munchy(String position, String name, BigDecimal price, String description, int inventory) {
        super(position, name, price, description, inventory);
    }

    @Override
    public String getSound() {
        String message = "Munchy, Munchy, so Good!";
        return message;
    }
}
