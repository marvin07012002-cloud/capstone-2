package com.pluralsight.deli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void drinkReturn(){
        Drink drink = new Drink(Size.SMALL);

        double drinkPrice =drink.getPrice();

        assertEquals(2,drinkPrice);
    }

}