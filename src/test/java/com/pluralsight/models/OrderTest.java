package com.pluralsight.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void testingOrderReturn() {
        Order order = new Order();
        Sandwich sandwich = new Sandwich();
        Drink drink = new Drink(Size.LARGE);
        Chips chips = new Chips();

        sandwich.setSize(Size.LARGE);

        order.addSandwich(sandwich);
        order.addDrink(drink);
        order.addChips(chips);

        double totalMoney = order.getTotalPrice();

        assertEquals(13 , totalMoney);
    }

}