package com.pluralsight.deli;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipsTest {

    @Test
    void chipsReturn (){
        Chips chips = new Chips();

        double chipsPrice = chips.getPrice();

        assertEquals(1.50,chipsPrice);
    }

}