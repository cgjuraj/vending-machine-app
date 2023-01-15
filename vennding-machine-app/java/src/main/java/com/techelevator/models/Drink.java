package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends Item{

    public Drink(String position, String name, BigDecimal price, String description, int inventory) {
        super(position, name, price, description, inventory);
    }

    @Override
    public String getSound() {
        String message = "Drinky, Drinky, Slurp Slurp!";
        return message;
    }
}
