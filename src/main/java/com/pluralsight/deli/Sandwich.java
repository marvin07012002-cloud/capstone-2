package com.pluralsight.deli;

import java.util.HashSet;

public class Sandwich implements PriceItem {
    private BreadType breadType;
    private Size size;
    private Meat meat;
    private boolean extraMeat;
    private Cheese cheese;
    private boolean extraCheese;
    private final HashSet<Sauces> sauces = new HashSet<>();
    private final HashSet<Toppings> toppings = new HashSet<>();
    private final HashSet<Side> sides = new HashSet<>();
    private boolean toasted;

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public void addSide(Side side) {
        sides.add(side);
    }

    public void addSauce(Sauces sauce) {
        sauces.add(sauce);
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public HashSet<Sauces> getSauces() {
        return sauces;
    }

    public HashSet<Toppings> getToppings() {
        return toppings;
    }

    public HashSet<Side> getSides() {
        return sides;
    }

    /**
     * Calculates the sandwich price based on size, selected premium toppings,
     * and whether extra meat or extra cheese was selected.
     *
     * @return The total price of this sandwich
     */
    @Override
    public double getPrice() {
        double breadPrice;
        double meatPrice;
        double cheesePrice;
        double totalPrice = 0;

        if (size == Size.SMALL) {
            breadPrice = 5.50;
            meatPrice = 1.00;
            cheesePrice = 0.75;
            if (meat != null) {
                totalPrice += meatPrice;
                if (extraMeat) {
                    totalPrice += 0.50;
                }
            }
            if (cheese != null) {
                totalPrice += cheesePrice;
                if (extraCheese) {
                    totalPrice += 0.30;
                }
            }
            totalPrice += breadPrice;


        } else if (size == Size.MEDIUM) {
            breadPrice = 7.00;
            meatPrice = 2.00;
            cheesePrice = 1.50;
            if (meat != null) {
                totalPrice += meatPrice;
                if (extraMeat) {
                    totalPrice += 1.00;
                }
            }
            if (cheese != null) {
                totalPrice += cheesePrice;
                if (extraCheese) {
                    totalPrice += 0.60;
                }
            }
            totalPrice += breadPrice;
        } else if (size == Size.LARGE) {
            breadPrice = 8.50;
            meatPrice = 3.00;
            cheesePrice = 2.25;
            if (meat != null) {
                totalPrice += meatPrice;
                if (extraMeat) {
                    totalPrice += 1.50;
                }
            }
            if (cheese != null) {
                totalPrice += cheesePrice;
                if (extraCheese) {
                    totalPrice += 0.90;
                }
            }
            totalPrice += breadPrice;
        }
        return totalPrice;
    }

    @Override
    public void displayDetails() {
        System.out.println("Sandwich");
        System.out.println("\tSize: " + this.size);
        System.out.println("\tBread: " + this.breadType);
        if (meat == null) {
            System.out.println("\tNO MEAT");
        } else {
            System.out.println("\tMeat: " + this.meat);
            if (extraMeat) {
                System.out.println("\tExtra Meat: Yes");
            }
        }
        if (cheese == null) {
            System.out.println("\tNO CHEESE");
        } else {
            System.out.println("\tCheese: " + this.cheese);
            if (extraCheese) {
                System.out.println("\tExtra Cheese: Yes");
            }
        }

        if (toasted) {
            System.out.println("\tToasted: Yes");
        } else {
            System.out.println("\tToasted: No");
        }


        System.out.println(" Toppings");
        if (toppings.isEmpty()) {
            System.out.println("\tNONE");
        } else {
            for (Toppings topping : toppings) {
                System.out.println("\t- " + topping);
            }
        }


        System.out.println(" Sauces");
        if (sauces.isEmpty()) {
            System.out.println("\tNONE");
        } else {
            for (Sauces sauce : sauces) {
                System.out.println("\t- " + sauce);
            }
        }

        System.out.println(" Sides");
        if (sides.isEmpty()) {
            System.out.println("\tNONE");
        } else {
            for (Side side : sides) {
                System.out.println("\t- " + side);
            }

        }
        System.out.printf("Sandwich Price: $%.2f\n", getPrice());


    }
}