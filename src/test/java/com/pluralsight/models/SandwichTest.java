package com.pluralsight.models;

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

}