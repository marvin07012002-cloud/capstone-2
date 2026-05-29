package com.pluralsight.deli;

public class Bec extends Sandwich {
    /**
     * Creates a default Bacon, Egg, and Cheese signature sandwich.
     * The sandwich can still be customized before being added to the order.
     */
    public Bec(){
        setSize(Size.MEDIUM);
        setBreadType(BreadType.ROLL);
        setMeat(Meat.BACON);
        setCheese(Cheese.AMERICAN);
        setToasted(true);
        addTopping(Toppings.EGGS);
    }


}
