package com.pluralsight.deli;

public class Blt extends Sandwich{

    public Blt(){
        setSize(Size.MEDIUM);
        setBreadType(BreadType.WHITE);
        setMeat(Meat.BACON);
        setCheese(Cheese.CHEDDAR);
        addTopping(Toppings.LETTUCE);
        addTopping(Toppings.TOMATOES);
        addSauce(Sauces.RANCH);
        setToasted(true);
    }
}
