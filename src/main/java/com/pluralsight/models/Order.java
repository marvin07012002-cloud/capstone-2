package com.pluralsight.models;

import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {
    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();
    private ArrayList<Chips> chips = new ArrayList<>();

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

    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }


    public ArrayList<Chips> getChips() {
        return chips;
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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");

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
                if(sandwich.getMeat()==null){
                    bufferedWriter.write("\tNO MEAT\n");
                }else {
                    bufferedWriter.write("\tMeat: "+ sandwich.getMeat()+"\n");
                    if(sandwich.isExtraMeat()){
                        bufferedWriter.write("\tExtra Meat: Yes\n");
                    }
                }

                if(sandwich.getCheese()==null){
                    bufferedWriter.write("\tNO CHEESE\n");
                }else {

                }

                bufferedWriter.write("Sandwich Total\n");
                bufferedWriter.write("\tPrice $" + sandwich.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            for (Drink drink : drinks) {
                bufferedWriter.write("Drinks Total\n");
                bufferedWriter.write("\tPrice $" + drink.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            for (Chips chip : chips) {
                bufferedWriter.write("Chips Total\n");
                bufferedWriter.write("\tPrice $" + chip.getPrice() + "\n");
                bufferedWriter.write("\n");
            }

            bufferedWriter.write("=================================");
            bufferedWriter.write("\n\tOrder Total:" + getTotalPrice());

            bufferedWriter.close();

            System.out.println("Receipt Save: " + fileName);
        } catch (IIOException e) {
            System.err.println("Error saving the receipt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
