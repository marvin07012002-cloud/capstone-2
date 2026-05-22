public class Main {

    public static void main(String[] args) {

        BreadType typeOfBread = BreadType.WHEAT;



        System.out.println(typeOfBread);

        if(typeOfBread == BreadType.WRAP) {
            System.out.println("You ordered a wrap... let's rap!");
        }

        Sandwich sandwich = new Sandwich();

        String output = """
                1. for white
                2. for wheat
                """;
        int userInput = 1;
        switch (userInput) {
            case 1:
            sandwich.setBreadType(BreadType.WHITE);
            break;

        }


        ///////

        if(sandwich.getSize = Size.LARGE) {
            System.out.println("12 inches... that's huge!");
        }


    }
}
