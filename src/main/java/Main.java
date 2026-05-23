public class Main {

    public static void main(String[] args) {
        Sandwich sandwich = new Sandwich();
        sandwich.setSize(Size.MEDIUM);
        sandwich.setMeat(Meat.BACON);
        sandwich.setExtraMeat(true);
        sandwich.addTopping(Toppings.CUCUMBERS);
        sandwich.addTopping(Toppings.LETTUCE);
        sandwich.addSauce(Sauces.THOUSAND_ISLANDS);
        sandwich.addSauce(Sauces.KETCHUP);
        sandwich.setSide(Side.SAUCE);


        System.out.println(sandwich.getPrice());
        BreadType typeOfBread = BreadType.WHEAT;


        System.out.println(typeOfBread);

        if (typeOfBread == BreadType.WRAP) {
            System.out.println("You ordered a wrap... let's rap!");
        }


        System.out.println("""
                1. for white
                2. for wheat
                """);
        int userInput = 1;
        switch (userInput) {
            case 1:
                sandwich.setBreadType(BreadType.WHITE);
                break;

        }


        ///////

//        if (Sandwich.getSize == Size.LARGE) {
//            System.out.println("12 inches... that's huge!");
//        }


    }
}
