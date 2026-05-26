package com.pluralsight.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private final ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private final ArrayList<Drink> drinks = new ArrayList<>();
    private final ArrayList<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chip) {
        chips.add(chip);
    }

    public double getTotalPrice() {
        double total = 0;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (Chips chips : chips) {
            total += chips.getPrice();
        }
        return total;
    }


    public boolean isEmpty() {
        return this.sandwiches.isEmpty() && this.drinks.isEmpty() && this.chips.isEmpty();
    }

    public void displayOrderDetails() {
        System.out.println("Order Summary");
        System.out.println("===========================");

        for (Sandwich sandwich : sandwiches) {
            sandwich.displayDetails();
            System.out.println();
        }
        for (Drink drink : drinks) {
            drink.displayDetails();
            System.out.println();
        }
        for (Chips chips : chips) {
            chips.displayDetails();
            System.out.println();
        }

        System.out.println("====================");
        System.out.printf("Order Total: $%.2f\n", getTotalPrice());


    }

    public String getReceiptName() {
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        return now.format(formatter) + ".txt";
    }

    public void saveReceipt() {
        try {
            String fileName = getReceiptName();

            FileWriter fileWriter = new FileWriter("src/main/resources/" + fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("\tOrder Summary\n");
            bufferedWriter.write("=================================\n");

            for (Sandwich sandwich : sandwiches) {
                bufferedWriter.write("Sandwich Detail\n");
                bufferedWriter.write("\tSize: " + sandwich.getSize() + "\n");
                bufferedWriter.write("\tBread: " + sandwich.getBreadType() + "\n");
                if (sandwich.getMeat() == null) {
                    bufferedWriter.write("\tNO MEAT\n");
                } else {
                    bufferedWriter.write("\tMeat: " + sandwich.getMeat() + "\n");
                    if (sandwich.isExtraMeat()) {
                        bufferedWriter.write("\tExtra Meat: Yes\n");
                    }
                }

                if (sandwich.getCheese() == null) {
                    bufferedWriter.write("\tNO CHEESE\n");
                } else {
                    bufferedWriter.write("\tCheese: " + sandwich.getCheese() + "\n");
                    if (sandwich.isExtraCheese()) {
                        bufferedWriter.write("\tExtra Cheese: Yes\n");
                    }
                }
                if (sandwich.isToasted()) {
                    bufferedWriter.write("\tToasted: Yes\n");
                } else {
                    bufferedWriter.write("\tNo Toasted\n");
                }

                bufferedWriter.write("\tToppings: \n");
                if (sandwich.getToppings().isEmpty()) {
                    bufferedWriter.write("\tNO TOPPINGS\n");
                } else {
                    for (Toppings topping : sandwich.getToppings()) {
                        bufferedWriter.write("\t\t-" + topping + "\n");
                    }
                }

                bufferedWriter.write("\tSauces\n");
                if (sandwich.getSauces().isEmpty()) {
                    bufferedWriter.write("\tNO SAUCE\n");
                } else {
                    for (Sauces sauce : sandwich.getSauces()) {
                        bufferedWriter.write("\t\t-" + sauce + "\n");
                    }
                }

                bufferedWriter.write("\tSides\n");
                if(sandwich.getSides().isEmpty()){
                    bufferedWriter.write("\tNO SIDE\n");
                }else {
                    for(Side side:sandwich.getSides()){
                        bufferedWriter.write("\t\t-"+side +"\n");
                    }
                }



                bufferedWriter.write("\tSandwich Total:\n");
                bufferedWriter.write("\tPrice $" + sandwich.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            for (Drink drink : drinks) {
                bufferedWriter.write("\tDrink Detail\n");
                bufferedWriter.write("\tDrink Size: " + drink.size + "\n");
                bufferedWriter.write("\tDrinks Tota:l\n");
                bufferedWriter.write("\tPrice $" + drink.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            for (Chips chip : chips) {
                bufferedWriter.write("\tChips Details\n");
                bufferedWriter.write("\tChips Total:\n");
                bufferedWriter.write("\tPrice $" + chip.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            bufferedWriter.write("==================================");
            bufferedWriter.write("\n\tOrder Total:" + getTotalPrice());

            bufferedWriter.close();

            System.out.println("Receipt Save: " + fileName);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
