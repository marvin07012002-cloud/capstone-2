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

    public boolean isEmpty(){
        return sandwiches.isEmpty() && drinks.isEmpty() && chips.isEmpty();
    }

    public void displayOrderDetails(){
        System.out.println("Order Details");
        System.out.println("===========================");



}
