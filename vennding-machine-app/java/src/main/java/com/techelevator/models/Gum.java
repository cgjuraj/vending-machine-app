package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Item{

    public Gum(String position, String name, BigDecimal price, String description, int inventory) {
        super(position, name, price, description, inventory);
    }

    @Override
    public String getSound() {
        String message = "Chewy, Chewy, Lots O Bubbles!";
        return message;
    }
}
