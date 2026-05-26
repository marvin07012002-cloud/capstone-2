package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);

    public void display() {
        boolean running = true;

        while (running) {
            System.out.println("""
                     ____  ____  __    __       ___  __  __   _  _  ____\s
                    (    \\(  __)(  )  (  )___  / __)(  )/  \\ / )( \\/ ___)
                     ) D ( ) _) / (_/\\ )((___)( (__  )((  O )) \\/ (\\___ \\
                    (____/(____)\\____/(__)     \\___)(__)\\__/ \\____/(____/
                    =============================================================
                                           1) New order
                                           0) Exit
                    
                                         Choose an option.
                    """);

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("1")) {
                Order order = new Order();
                displayMenu(order);
            } else if (choice.equalsIgnoreCase("0")) {
                running = false;
                System.out.println("""
                        \t▄▖     ▌  ▄       ▌
                        \t▌ ▛▌▛▌▛▌  ▙▘▌▌█▌  ▌
                        \t▙▌▙▌▙▌▙▌  ▙▘▙▌▙▖  ▖
                                    \t▄▌    \s""");

            } else {
                System.err.println("""
                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                     \s""");
            }

        }
    }

    private void displayMenu(Order order) {

        while (true) {
            System.out.println("""
                      ___   ____   ___      ___  ____       ___ ___    ___  ____   __ __\s
                     /   \\ |    \\ |   \\    /  _]|    \\     |   |   |  /  _]|    \\ |  |  |
                    |     ||  D  )|    \\  /  [_ |  D  )    | _   _ | /  [_ |  _  ||  |  |
                    |  O  ||    / |  D  ||    _]|    /     |  \\_/  ||    _]|  |  ||  |  |
                    |     ||    \\ |     ||   [_ |    \\     |   |   ||   [_ |  |  ||  :  |
                    |     ||  .  \\|     ||     ||  .  \\    |   |   ||     ||  |  ||     |
                     \\___/ |__|\\_||_____||_____||__|\\_|    |___|___||_____||__|__| \\__,_|
                    
                     =============================================================
                                           1) Add Custom Sandwich
                                           2) Add Signature Sandwich
                                           3) Add Drinks
                                           4) Add Chips
                                           5) Checkout
                                           0) Cancel Order
                    
                                          Choose an option.
                    
                    
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwichToOrder(order);
                    break;
                case "2":
                    addSignatureSandichToOrder(order);
                    break;
                case "3":
                    addDrinkToOrder(order);
                    break;
                case "4":
                    addChipsToOrder(order);
                    break;
                case "5":
                    if (order.isEmpty()) {
                        System.err.println("\tYou must at least add one item before check out.");
                        break;
                    } else {
                        while (true) {
                            order.displayOrderDetails();
                            System.out.println("Confirm Check out? Yes/No: ");
                            String confirm = scanner.nextLine();

                            if (confirm.equalsIgnoreCase("Yes")) {
                                order.saveReceipt();
                                return;
                            } else if (confirm.equalsIgnoreCase("No")) {
                                System.out.println("Check out Cancel");
                                break;
                            } else {
                                System.err.println("""
                                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                                     \s""");
                            }
                        }
                    }
                    break;

                case "0":
                    System.err.println("\tOrder Cancelled");
                    return;
                default:
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
            }
        }
    }

    private void addSignatureSandichToOrder(Order order) {
        Sandwich sandwich = null;
        boolean signing = true;

        while (signing){
            System.out.println("""
                     What signature Sandwich would you like?
                     
                     1) BLT
                     2) Philly Cheese Steak
                     0) Cancel
                     
                     Choose an option.
                    
                    """);

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    sandwich = new Blt();
                    System.out.println("BLT added successfully");
                    signing = false;
                    break;
                case"2":
                    sandwich = new PhillyCheeseSteak();
                    System.out.println("Philly Cheese Steak added successfully");
                    signing = false;
                    break;
                case "0":
                    return;
                default:
                    System.err.println("""
                                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                                     \s""");
            }

            sandwich.displayDetails();

        }

    }

    private void addSandwichToOrder(Order order) {
        Sandwich sandwich = new Sandwich();

        while (sandwich.getSize() == null) {
            System.out.println("""
                    Select sandwich size
                    
                    1) Small 4 Inch
                    2) Medium 8 Inch
                    3) Large 12 Inch
                    4) Cancel
                    
                     Choose an option.
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.setSize(Size.SMALL);
                    break;
                case "2":
                    sandwich.setSize(Size.MEDIUM);
                    break;
                case "3":
                    sandwich.setSize(Size.LARGE);
                    break;
                case "4":
                    return;
                default:
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
            }
        }
        while (sandwich.getBreadType() == null) {
            System.out.println("""
                       What type of bread would you like?
                    
                       1) White Bread
                       2) Wheat Bread
                       3) Rye Bread
                       4) Wrap Bread
                    
                    
                    Choose an option.
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.setBreadType(BreadType.WHITE);
                    break;
                case "2":
                    sandwich.setBreadType(BreadType.WHEAT);
                    break;
                case "3":
                    sandwich.setBreadType(BreadType.RYE);
                    break;
                case "4":
                    sandwich.setBreadType(BreadType.WRAP);
                    break;
                default:
                    System.err.println("""
                            ███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗
                            ██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
                            ███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║
                            ╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║
                            ███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║
                            ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
                                                                                                                                                      \s""");
            }
        }
        boolean choosing = true;
        while (choosing) {
            System.out.println("""
                     What meat would you like?
                    
                      1) Steak
                      2) Ham
                      3) Salami
                      4) Roast Beef
                      5) Chicken
                      6) Bacon
                      7) No Meat
                    
                      Choose an option.
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.setMeat(Meat.STEAK);
                    choosing = false;
                    break;
                case "2":
                    sandwich.setMeat(Meat.HAM);
                    choosing = false;
                    break;
                case "3":
                    sandwich.setMeat(Meat.SALAMI);
                    choosing = false;
                    break;
                case "4":
                    sandwich.setMeat(Meat.ROAST_BEEF);
                    choosing = false;
                    break;
                case "5":
                    sandwich.setMeat(Meat.CHICKEN);
                    choosing = false;
                    break;
                case "6":
                    sandwich.setMeat(Meat.BACON);
                    choosing = false;
                    break;
                case "7":
                    choosing = false;
                    break;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");

            }
            if (!(sandwich.getMeat() == null)) {
                boolean running = true;
                while (running) {
                    System.out.println(" Would you like extra meat? Yes/No");
                    String chooice = scanner.nextLine();
                    if (chooice.equalsIgnoreCase("yes")) {
                        sandwich.setExtraMeat(true);
                        break;
                    } else if (chooice.equalsIgnoreCase("no")) {
                        running = false;
                        break;
                    } else {
                        System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                                "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                                "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                                "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                                "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                                "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                                "                                                                                                                           ");
                    }
                }
            }
        }
        boolean running = true;
        while (running) {
            System.out.println("""
                     What kind of cheese would you like?
                    
                     1) American
                     2) Provolone
                     3) Cheddar
                     4) Swiss
                     5) No Cheese
                    
                     Choose an option.
                    """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    sandwich.setCheese(Cheese.AMERICAN);
                    running = false;
                    break;
                case "2":
                    sandwich.setCheese(Cheese.PROVOLONE);
                    running = false;
                    break;
                case "3":
                    sandwich.setCheese(Cheese.CHEDDAR);
                    running = false;
                    break;
                case "4":
                    sandwich.setCheese(Cheese.SWISS);
                    running = false;
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");
            }

            if (!(sandwich.getCheese() == null)) {
                boolean cheesing = true;
                while (cheesing == true) {
                    System.out.println("Would you like Extra Cheese? Yes/No");
                    String option = scanner.nextLine();
                    if (option.equalsIgnoreCase("yes")) {
                        sandwich.setExtraCheese(true);
                        break;
                    } else if (option.equalsIgnoreCase("no")) {
                        cheesing = false;
                        break;
                    } else {
                        System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                                "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                                "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                                "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                                "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                                "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                                "                                                                                                                           ");
                    }
                }
            }
        }

        boolean addingToppings = true;

        while (addingToppings == true) {
            System.out.println("""
                     What toppings would you like to add?
                    
                     1) Lettuce
                     2) Peppers
                     3) Onions
                     4) Tomatoes
                     5) Jalapenos
                     6) Cucumbers
                     7) Pickles
                     8) Guacamole
                     9) Mushrooms
                     0) Done or None
                    
                     Choose your options.
                    
                    """);

            String puttingTopping = scanner.nextLine();

            switch (puttingTopping) {
                case "1":
                    sandwich.addTopping(Toppings.LETTUCE);
                    System.out.println("Lettuce Added!.");
                    break;
                case "2":
                    sandwich.addTopping(Toppings.PEPPERS);
                    System.out.println("Peppers Added!.");
                    break;
                case "3":
                    sandwich.addTopping(Toppings.ONIONS);
                    System.out.println("Onions Added!.");
                    break;
                case "4":
                    sandwich.addTopping(Toppings.TOMATOES);
                    System.out.println("Tomatoes Added!.");
                    break;
                case "5":
                    sandwich.addTopping(Toppings.JALAPENOS);
                    System.out.println("Jalapenos Added!.");
                    break;
                case "6":
                    sandwich.addTopping(Toppings.CUCUMBERS);
                    System.out.println("Cucumbers Added!.");
                    break;
                case "7":
                    sandwich.addTopping(Toppings.PICKLES);
                    System.out.println("Pickles Added!.");
                    break;
                case "8":
                    sandwich.addTopping(Toppings.GUACAMOLE);
                    System.out.println("Guacamole Added!.");
                    break;
                case "9":
                    sandwich.addTopping(Toppings.MUSHROOM);
                    System.out.println("Mushrooms Added!.");
                    break;
                case "0":
                    addingToppings = false;
                    break;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");
            }
        }

        boolean addingSauces = true;

        while (addingSauces == true) {
            System.out.println("""
                     What sauces would you like?
                    
                     1) Mayo
                     2) Mustard
                     3) Ketchup
                     4) Ranch
                     5) Thousand Islands
                     6) Vinaigrette
                     0) Done or None
                    
                     Choose your sauces!
                    
                    """);
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    sandwich.addSauce(Sauces.MAYO);
                    System.out.println("Mayo Added!");
                    break;
                case "2":
                    sandwich.addSauce(Sauces.MUSTARD);
                    System.out.println("Mustard Added!");
                    break;
                case "3":
                    sandwich.addSauce(Sauces.KETCHUP);
                    System.out.println("Ketchup Added!");
                    break;
                case "4":
                    sandwich.addSauce(Sauces.RANCH);
                    System.out.println("Ranch Added!");
                    break;
                case "5":
                    sandwich.addSauce(Sauces.THOUSAND_ISLANDS);
                    System.out.println("Thousand Islands Added!");
                    break;
                case "6":
                    sandwich.addSauce(Sauces.VINAIGRETTE);
                    System.out.println("Vinaigrette Added!");
                    break;
                case "0":
                    addingSauces = false;
                    break;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");
            }

        }
        boolean toasting = true;
        while (toasting == true) {
            System.out.println("Do you want it Toasted? Yes/No");
            String isItToasted = scanner.nextLine();
            if (isItToasted.equalsIgnoreCase("Yes")) {
                sandwich.setToasted(true);
                break;
            } else if (isItToasted.equalsIgnoreCase("no")) {
                toasting = false;
                break;
            } else {
                System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                        "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                        "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                        "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                        "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                        "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                        "                                                                                                                           ");
            }
        }

        boolean addingSides = true;

        while (addingSides == true) {
            System.out.println("""
                     What sides would you like?
                    
                     1) Au Jus
                     2) Sauce
                     0) Done or None
                    
                     Choose a Sauce
                    
                    """
            );
            String election = scanner.nextLine();

            switch (election) {
                case "1":
                    sandwich.addSide(Side.AU_JUS);
                    System.out.println("Side Au Jus Added!");
                    break;
                case "2":
                    sandwich.addSide(Side.SAUCE);
                    System.out.println("Side Sauce Added!");
                    break;
                case "0":
                    addingSides = false;
                    break;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");
            }
        }

        sandwich.displayDetails();
        while (true) {
            System.out.println("Would you like to add Sandwich to the Order? Yes/No");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("yes")) {
                order.addSandwich(sandwich);
                System.out.println("Your Sandwich has been added successfully!");
                return;
            } else if (choice.equalsIgnoreCase("no")) {
                System.err.println("Sandwich Cancelled.");
                break;
            } else {
                System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                        "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                        "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                        "                              ");
            }
        }
    }

    private void addDrinkToOrder(Order order) {
        Drink drink = null;

        while (drink == null) {
            System.out.println("""
                    What drink size would you like?
                    1) Small
                    2) Medium
                    3) Large
                    4) Cancel
                    
                    Choose an option.
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    drink = new Drink(Size.SMALL);
                    break;
                case "2":
                    drink = new Drink(Size.MEDIUM);
                    break;
                case "3":
                    drink = new Drink(Size.LARGE);
                    break;
                case "4":
                    return;
                default:
                    System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                            "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                            "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                            "                              ");
            }
        }

        drink.displayDetails();
        while (true) {
            System.out.println("Would you like to add the drink to the order? Yes/No");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("yes")) {
                order.addDrink(drink);
                System.out.println("\tDrink Added Successfully");
                return;
            } else if (choice.equalsIgnoreCase("no")) {
                System.err.println("Drink cancelled");
                return;
            } else {
                System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                        "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                        "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                        "                              ");
            }
        }

    }

    private void addChipsToOrder(Order order) {
        Chips chips = new Chips();

        chips.displayDetails();


        while (true) {
            System.out.println("You want to add Chips to the Order? Yes/No");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                order.addChips(chips);
                System.out.println("Chips Added Successfully!");
                return;
            } else if (confirm.equalsIgnoreCase("no")) {
                System.err.println("Chips Cancelled");
                return;
            } else {
                System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                        "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                        "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                        "                              ");
            }
        }

    }
}