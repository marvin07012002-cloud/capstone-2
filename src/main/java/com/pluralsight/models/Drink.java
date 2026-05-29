package com.pluralsight.models;

public class Drink implements PriceItem {
    Size size;

    public Drink(Size size) {
        this.size = size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Calculates the drink price based only on size.
     *
     * @return The price of this drink
     */
    @Override
    public double getPrice() {

        double price;
        switch (this.size) {
            case SMALL:
                price = 2.00;
                break;
            case MEDIUM:
                price = 2.50;
                break;
            case LARGE:
                price = 3.00;
                break;
            default:
                throw new RuntimeException("invalid size");
        }

        return price;
    }

    @Override
    public void displayDetails() {
        System.out.println("Drink");
        System.out.println("\tSize: " + this.size);
        System.out.printf("\tDrink Price: $%.2f\n",getPrice());
    }
}
