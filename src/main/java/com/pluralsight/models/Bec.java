package com.pluralsight.models;

public class Bec extends Sandwich {
    public Bec(){
        setSize(Size.MEDIUM);
        setBreadType(BreadType.ROLL);
        setMeat(Meat.BACON);
        setCheese(Cheese.AMERICAN);
        setToasted(true);
        addTopping(Toppings.EGGS);
    }


}
