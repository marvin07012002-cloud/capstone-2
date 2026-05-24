import com.pluralsight.models.*;

public class Main {

    public static void main(String[] args) {
//        Sandwich sandwich1 = new com.pluralsight.models.Sandwich();
//        sandwich1.setSize(Size.MEDIUM);
//        sandwich1.setMeat(Meat.BACON);
//        sandwich1.setExtraMeat(true);
//        sandwich1.setCheese(Cheese.PROVOLONE);
//        sandwich1.addTopping(Toppings.CUCUMBERS);
//        sandwich1.addTopping(Toppings.LETTUCE);
//        sandwich1.addSauce(Sauces.THOUSAND_ISLANDS);
//        sandwich1.addSauce(models.Sauces.KETCHUP);
//
//       Order order = new Order();
//       order.addDrink();
//       order.displayOrderDetails();

        Order order = new Order();

        Sandwich sandwich1 = new Sandwich();
        sandwich1.setSize(Size.SMALL);
        sandwich1.setBreadType(BreadType.WHITE);
        sandwich1.setMeat(Meat.STEAK);
        sandwich1.setExtraMeat(true);
        sandwich1.setCheese(Cheese.AMERICAN);
        sandwich1.addTopping(Toppings.LETTUCE);
        sandwich1.addTopping(Toppings.TOMATOES);
        sandwich1.addSauce(Sauces.MAYO);
        sandwich1.setToasted(true);

        order.addSandwich(sandwich1);

        Drink drink = new Drink(Size.MEDIUM);
        order.addDrink(drink);

        Chips chips = new Chips();
        order.addChips(chips);

        order.displayOrderDetails();
    }






//        System.out.println(sandwich1.getPrice());
//        BreadType typeOfBread = com.pluralsight.models.BreadType.WHEAT;
//
//
//        System.out.println(typeOfBread);
//
//        if (typeOfBread == com.pluralsight.models.BreadType.WRAP) {
//            System.out.println("You ordered a wrap... let's rap!");
//        }
//
//
//        System.out.println("""
//                1. for white
//                2. for wheat
//                """);
//        int userInput = 1;
//        switch (userInput) {
//            case 1:
//                sandwich1.setBreadType(BreadType.WHITE);
//                break;
//
//        }
//
//
//        ///////
//

    }
