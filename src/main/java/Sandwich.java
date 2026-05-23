import java.util.ArrayList;

public class Sandwich {
    private BreadType breadType;
    private Size size;
    private Meat meat;
    private boolean extraMeat;
    private Cheese cheese;
    private boolean extraCheese;
    private ArrayList<Sauces> sauces = new ArrayList<>();
    private ArrayList<Toppings> toppings = new ArrayList<>();
    private Side side;
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

    public void addSauce(Sauces sauce) {
        sauces.add(sauce);
    }

    public ArrayList<Sauces> getSauces() {
        return sauces;
    }

    public void setSauces(ArrayList<Sauces> sauces) {
        this.sauces = sauces;
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

    public ArrayList<Toppings> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Toppings> toppings) {
        this.toppings = toppings;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public boolean isToasted() {
        return toasted;
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public double getPrice() {
        double breadPrice = 0;
        double meatPrice = 0;
        double cheesePrice = 0;
        double totalPrice = 0;

        if (size == Size.SMALL) {
            breadPrice = 5.50;
            meatPrice = 1.00;
            cheesePrice = 0.75;
            totalPrice = breadPrice + meatPrice + cheesePrice;
            if (extraMeat == true) {
                totalPrice += 0.50;
            }
            if (extraCheese == true) {
                totalPrice += 0.30;
            }
        } else if (size == Size.MEDIUM) {
            breadPrice = 7.00;
            meatPrice = 2.00;
            cheesePrice = 1.50;
            totalPrice = breadPrice + meatPrice + cheesePrice;
            if (extraMeat == true) {
                totalPrice += 1.00;
            }
            if (extraCheese == true) {
                totalPrice += 0.60;
                ;
            } else if (size == Size.LARGE) {
                breadPrice = 8.50;
                meatPrice = 3.00;
                cheesePrice = 2.25;
                totalPrice = breadPrice + meatPrice + cheesePrice;
                if (extraMeat == true) {
                    totalPrice += 1.50;
                }
                if (extraCheese == true) {
                    totalPrice += 0.90;
                    ;
                }

            }
        }
        return totalPrice;
    }
}
