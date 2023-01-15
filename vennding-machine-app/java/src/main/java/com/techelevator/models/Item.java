package com.techelevator.models;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class Item{

    //Variables
    private String position;
    private String name;
    private BigDecimal price;
    private String description;
    private int inventory;

    public int getInventory() {
        return inventory;
    }

    //Constructor
    public Item(String position, String name, BigDecimal price, String description, int inventory) {
        this.position = position;
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventory = inventory;
    }

    //Getters & Setters
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract String getSound();

    //Method subtracts 1 from the specific item inventory each time an item is purchased.
    public int itemPurchased() {
        return this.inventory = inventory - 1;
    }

    public boolean inStock() {
        if (inventory == 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
