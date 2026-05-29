package com.pluralsight.deli;

public class Chips implements PriceItem {
    /**
     * Returns the fixed price for chips.
     *
     * @return The price of chips
     */
    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public void displayDetails() {
        System.out.println("Chips");
        System.out.printf("\tChips Price: $%.2f\n ",getPrice());

    }
}
