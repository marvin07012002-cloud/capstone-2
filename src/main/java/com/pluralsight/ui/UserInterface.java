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
                    addSignatureSandwichToOrder(order);
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

    private void addSignatureSandwichToOrder(Order order) {
        boolean signing = true;
        Sandwich sandwich = null;

        while (signing) {
            System.out.println("""
                     What signature Sandwich would you like?
                    
                     1) BLT
                     2) Philly Cheese Steak
                     3) Beacon Egg and Cheese
                     0) Cancel
                    
                     Choose an option.
                    
                    """);

            String choice = scanner.nextLine();
            switch (choice) {

                case "1":
                    sandwich = new Blt();
                    System.out.println("BLT added successfully");
                    signing = false;
                    break;
                case "2":
                    sandwich = new PhillyCheeseSteak();
                    System.out.println("Philly Cheese Steak added successfully");
                    signing = false;
                    break;
                case "3":
                    boolean choosingBread = true;
                    while (choosingBread) {
                        System.out.println("""
                                What bread would you Like?
                                1) Hero
                                2) Roll
                                0) Cancel
                                """);
                        String signatureChoice = scanner.nextLine();
                        switch (signatureChoice) {
                            case "1":
                                sandwich = new Bec();
                                sandwich.setBreadType(BreadType.HERO);
                                sandwich.setSize(Size.LARGE);
                                System.out.println("Beacon, Egg and Cheese added successfully");
                                choosingBread = false;
                                signing = false;
                                break;
                            case "2":
                                sandwich = new Bec();
                                System.out.println("Beacon, Egg and Cheese added successfully");
                                choosingBread = false;
                                signing = false;
                                break;
                            case "0":
                                System.err.println("Cancelled");
                                return;
                            default:
                                System.err.println("""
                                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                                     \s""");
                                break;
                        }
                    }
                    break;
                case "0":
                    System.err.println("Cancelled");
                    return;
                default:
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
                    break;
            }

        }


        while (true) {
            sandwich.displayDetails();
            System.out.println("Would you like to added this Sandwich to your order? Yes/No");
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("Yes")) {
                order.addSandwich(sandwich);
                System.out.println("Sandwich Added Successfully!");
                return;
            } else if (selection.equalsIgnoreCase("no")) {
                System.err.println("Signature Sandwich canceled.");
                return;
            } else {
                System.err.println("""
                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                     \s""");

            }
        }
    }


    private void addSandwichToOrder(Order order) {
        Sandwich sandwich = new Sandwich();

        if (sizeType(sandwich)) return;
        getBread(sandwich);
        addMeatToSandwich(sandwich);

        addCheeseToSandwich(sandwich);

        addTopping(sandwich);

        addSauce(sandwich);

        isItToasted(sandwich);

        addSides(sandwich);

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
                System.err.println("""
                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                     \s""");
            }
        }
    }

    private void getBread(Sandwich sandwich) {
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
    }

    private boolean sizeType(Sandwich sandwich) {
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
                    return true;
                default:
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
            }
        }
        return false;
    }

    private void addSides(Sandwich sandwich) {
        boolean addingSides = true;

        while (addingSides) {
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
    }

    private void isItToasted(Sandwich sandwich) {
        while (true) {
            System.out.println("Do you want it Toasted? Yes/No");
            String isItToasted = scanner.nextLine();
            if (isItToasted.equalsIgnoreCase("Yes")) {
                sandwich.setToasted(true);
                break;
            } else if (isItToasted.equalsIgnoreCase("no")) {
                break;
            } else {
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
    }

    private void addCheeseToSandwich(Sandwich sandwich) {
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
                    System.err.println("""
                            ███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗
                            ██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
                            ███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║
                            ╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║
                            ███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║
                            ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
                                                                                                                                                      \s""");
            }

            if (!(sandwich.getCheese() == null)) {
                while (true) {
                    System.out.println("Would you like Extra Cheese? Yes/No");
                    String option = scanner.nextLine();
                    if (option.equalsIgnoreCase("yes")) {
                        sandwich.setExtraCheese(true);
                        break;
                    } else if (option.equalsIgnoreCase("no")) {
                        break;
                    } else {
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
            }
        }
    }

    private void addMeatToSandwich(Sandwich sandwich) {
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
                    System.err.println("""
                            ███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗
                            ██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║
                            ███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║
                            ╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║
                            ███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║
                            ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝
                                                                                                                                                      \s""");

            }
            if (!(sandwich.getMeat() == null)) {

                while (true) {
                    System.out.println(" Would you like extra meat? Yes/No");
                    String selection = scanner.nextLine();
                    if (selection.equalsIgnoreCase("yes")) {
                        sandwich.setExtraMeat(true);
                        break;
                    } else if (selection.equalsIgnoreCase("no")) {
                        break;
                    } else {
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
            }
        }
    }

    private void addSauce(Sandwich sandwich) {
        boolean addingSauces = true;

        while (addingSauces) {
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
    }

    private void addTopping(Sandwich sandwich) {
        boolean adding = true;

        while (adding) {
            System.out.println("\tWhat Toppings Would you like?\n");
            if (!sandwich.getToppings().contains(Toppings.LETTUCE)) {
                System.out.println("1) Add Lettuce");
            }
            if (!sandwich.getToppings().contains(Toppings.PEPPERS)) {
                System.out.println("2) Add Peppers");
            }
            if (!sandwich.getToppings().contains(Toppings.ONIONS)) {
                System.out.println("3) Add Onions");
            }
            if (!sandwich.getToppings().contains(Toppings.TOMATOES)) {
                System.out.println("4) Add Tomatoes");
            }
            if (!sandwich.getToppings().contains(Toppings.JALAPENOS)) {
                System.out.println("5) Add Jalapenos");
            }
            if (!sandwich.getToppings().contains(Toppings.CUCUMBERS)) {
                System.out.println("6) Add Cucumbers");
            }
            if (!sandwich.getToppings().contains(Toppings.PICKLES)) {
                System.out.println("7) Add Pickles");
            }
            if (!sandwich.getToppings().contains(Toppings.GUACAMOLE)) {
                System.out.println("8) Add Guacamole");
            }
            if (!sandwich.getToppings().contains(Toppings.MUSHROOM)) {
                System.out.println("9) Add Mushrooms");
            }
            System.out.println("0) Done or None\n");
            System.out.println("Choose and option");
            System.out.println(" ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (!sandwich.getToppings().contains(Toppings.LETTUCE)) {
                        sandwich.addTopping(Toppings.LETTUCE);
                        System.out.println("Lettuce Added!\n");
                    } else {
                        System.err.println("You Already Add Lettuce");
                    }
                    break;
                case "2":
                    if (!sandwich.getToppings().contains(Toppings.PEPPERS)) {
                        sandwich.addTopping(Toppings.PEPPERS);
                        System.out.println("Peppers Added!\n");
                        break;
                    } else {
                        System.err.println("You Already Add Peppers");
                    }
                    break;
                case "3":
                    if (!sandwich.getToppings().contains(Toppings.ONIONS)) {
                        sandwich.addTopping(Toppings.ONIONS);
                        System.out.println("Onions Added!\n");
                    } else {
                        System.err.println("You Already Add Onions");
                    }
                    break;
                case "4":
                    if (!sandwich.getToppings().contains(Toppings.TOMATOES)) {
                        sandwich.addTopping(Toppings.TOMATOES);
                        System.out.println("Tomatoes Added!\n");
                    } else {
                        System.err.println("You Already Add Tomatoes");
                    }
                    break;
                case "5":
                    if (!sandwich.getToppings().contains(Toppings.JALAPENOS)) {
                        sandwich.addTopping(Toppings.JALAPENOS);
                        System.out.println("Jalapenos Added!\n");
                    } else {
                        System.err.println("You Already Add Jalapenos");
                    }
                    break;
                case "6":
                    if (!sandwich.getToppings().contains(Toppings.CUCUMBERS)) {
                        sandwich.addTopping(Toppings.CUCUMBERS);
                        System.out.println("Cucumbers Added!\n");
                    } else {
                        System.err.println("You Already Add Cucumbers");
                    }
                    break;
                case "7":
                    if (!sandwich.getToppings().contains(Toppings.PICKLES)) {
                        sandwich.addTopping(Toppings.PICKLES);
                        System.out.println("Pickles Added!\n");
                    } else {
                        System.err.println("You Already Add Pickles");
                    }
                    break;
                case "8":
                    if (!sandwich.getToppings().contains(Toppings.GUACAMOLE)) {
                        sandwich.addTopping(Toppings.GUACAMOLE);
                        System.out.println("Guacamole Added!\n");
                    } else {
                        System.err.println("You Already Add Guacamole");
                    }
                    break;
                case "9":
                    if(!sandwich.getToppings().contains(Toppings.MUSHROOM)){
                        sandwich.addTopping(Toppings.MUSHROOM);
                        System.out.println("Mushrooms Added!\n");
                    }else {
                        System.err.println("You Already Add Mushroom");
                    }
                    break;
                case "0":
                    adding = false;
                    break;
                default:
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
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
                    System.err.println("""
                            \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                            \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                            \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                         \s""");
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
                System.err.println("""
                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                     \s""");
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
                System.err.println("""
                        \t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖
                        \t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌
                        \t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌
                                                     \s""");
            }
        }

    }
}