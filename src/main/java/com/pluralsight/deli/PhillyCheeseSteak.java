package com.pluralsight.deli;

public class PhillyCheeseSteak extends Sandwich{

    public PhillyCheeseSteak(){
        setSize(Size.MEDIUM);
        setBreadType(BreadType.WHITE);
        setMeat(Meat.STEAK);
        setCheese(Cheese.AMERICAN);
        addTopping(Toppings.PEPPERS);
        addSauce(Sauces.MAYO);
        setToasted(true);
    }
}
