public class Main {

    public static void main(String[] args) {
        Sandwich sandwich1 = new Sandwich();
        sandwich1.setSize(Size.MEDIUM);
        sandwich1.setMeat(Meat.BACON);
        sandwich1.setExtraMeat(true);
        sandwich1.setCheese(Cheese.PROVOLONE);
        sandwich1.addTopping(Toppings.CUCUMBERS);
        sandwich1.addTopping(Toppings.LETTUCE);
        sandwich1.addSauce(Sauces.THOUSAND_ISLANDS);
        sandwich1.addSauce(Sauces.KETCHUP);
        sandwich1.setSide(Side.SAUCE);

        Drink drink = new Drink(Size.MEDIUM);
        drink.displayDetails();






        System.out.println(sandwich1.getPrice());
//        BreadType typeOfBread = BreadType.WHEAT;
//
//
//        System.out.println(typeOfBread);
//
//        if (typeOfBread == BreadType.WRAP) {
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
////        if (Sandwich.getSize == Size.LARGE) {
////            System.out.println("12 inches... that's huge!");
////        }
//
//
//    }
    }}
