# 😎 Marbin's DELI-cious Sandwich Shop Application 😎

## 👀 Description 👀
This is a Java console application for **DELI-cious**, a custom sandwich shop point-of-sale system.

Customers can create an order, add custom sandwiches, add signature sandwiches, add drinks and chips, review their order, check out, cancel, and save a receipt with the current date and time.

The project uses object-oriented programming with classes like `Order`, `Sandwich`, `Drink`, `Chips`, and signature sandwich classes. I also used enums for bread, size, meat, cheese, toppings, sauces, and sides.

## Main Features 👁️ 👄 👁 ️

- Add custom sandwiches
- Add signature sandwiches
- Customize sandwiches
- Add drinks and chips
- Prevent duplicate toppings, sauces, and sides with `HashSet`
- Display order details before checkout
- Calculate the total price
- Save receipts
- Cancel orders

## 🏃🏻‍♀️Running 🏃🏿the🏃🏻‍ Code 🏃🏽‍♂️  

Open the project in **IntelliJ IDEA Community Edition** and run the `Main` class.

# 👾Diagrams👾
## Diagram Before Coding😭😫😖

This was my original class diagram before I started coding.


![Before Coding](src/images/before-coding.png)

## Diagram After Coding 🫨😉😏

This is my updated diagram after building the application.


![Ater conding](src/images/after-coding.png)

## My Personal Challenges🥵
One of my biggest challenges was knowing where to start. At first,
I wanted to build everything at once, but I learned to break the project
into smaller steps. I also learned the difference between ArrayList and HashSet.
I changed toppings, sauces, and sides to HashSet because they should not
allow duplicates.

## Code I'm Most Proud Of🫡

I am most proud of my `getPrice()` method in the `Sandwich` class. This method calculates the price based on the sandwich size, meat, cheese, extra meat, and extra cheese.

I like this code because it was one of the first big pieces of business logic I got working correctly. It also helped me understand how objects can be responsible for their own behavior.

```java
@Override
public double getPrice() {
    double breadPrice;
    double meatPrice;
    double cheesePrice;
    double totalPrice = 0;

    if (size == Size.SMALL) {
        breadPrice = 5.50;
        meatPrice = 1.00;
        cheesePrice = 0.75;

        if (meat != null) {
            totalPrice += meatPrice;
            if (extraMeat) {
                totalPrice += 0.50;
            }
        }

        if (cheese != null) {
            totalPrice += cheesePrice;
            if (extraCheese) {
                totalPrice += 0.30;
            }
        }

        totalPrice += breadPrice;
    } else if (size == Size.MEDIUM) {
        breadPrice = 7.00;
        meatPrice = 2.00;
        cheesePrice = 1.50;

        if (meat != null) {
            totalPrice += meatPrice;
            if (extraMeat) {
                totalPrice += 1.00;
            }
        }

        if (cheese != null) {
            totalPrice += cheesePrice;
            if (extraCheese) {
                totalPrice += 0.60;
            }
        }

        totalPrice += breadPrice;
    } else if (size == Size.LARGE) {
        breadPrice = 8.50;
        meatPrice = 3.00;
        cheesePrice = 2.25;

        if (meat != null) {
            totalPrice += meatPrice;
            if (extraMeat) {
                totalPrice += 1.50;
            }
        }

        if (cheese != null) {
            totalPrice += cheesePrice;
            if (extraCheese) {
                totalPrice += 0.90;
            }
        }

        totalPrice += breadPrice;
    }

    return totalPrice;
}
```
## What I Learned🤓
In this capstone, I practiced:

- Classes and objects
- Encapsulation
- Inheritance
- Interfaces
- Enums
- `ArrayList`
- `HashSet`
- Loops and menus
- Writing files with `FileWriter` and `BufferedWriter`iter

## Next Time🫵🏽
Next time, I would plan the class diagram more carefully and reduce repeated code.
Overall, this project helped me feel more confident building a larger Java application.