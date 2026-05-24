package com.pluralsight.models;

public class Chips implements PriceItem {

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void displayDetails() {
        System.out.println("Chips");
        System.out.printf("Chips Price: $%.2f\n ",getPrice());

    }
}
