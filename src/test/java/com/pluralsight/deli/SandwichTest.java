package com.pluralsight.deli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void returnsBasePrice (){
        Sandwich sandwich = new Sandwich();

        sandwich.setSize(Size.LARGE);
        sandwich.setBreadType(BreadType.WRAP);

        double priceReturn = sandwich.getPrice();

        assertEquals(8.50,priceReturn);
    }

    @Test
    void checkingBLT(){
        Sandwich bLT = new Blt();

        double bltPrice = bLT.getPrice();

        assertEquals(10.50,bltPrice);
    }

    @Test
    void checkingCheeseSteak(){
        Sandwich cheeseSteak = new PhillyCheeseSteak();

        double priceCheeseSteak = cheeseSteak.getPrice();

        assertEquals(10.50,priceCheeseSteak);
    }

}