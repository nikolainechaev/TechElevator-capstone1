package com.techelevator;

public class Drink implements Sellable{

    private String name;
    private String slotNumber;
    private double price;
    private String type = "Drink";

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSlotNumber(String slot) {
        this.slotNumber = slot;
    }

    @Override
    public String getSlotNumber() {
        return this.slotNumber;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }


    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void getNoise() {
        System.out.println("Glug Glug, Yum!");
    }

}
