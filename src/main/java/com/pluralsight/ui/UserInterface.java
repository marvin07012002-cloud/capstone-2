package com.pluralsight.ui;

import com.pluralsight.deli.*;

import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Starts the main application loop.
     * Displays the home screen until the user chooses to exit.
     */
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

    /**
     * Displays the order menu for the current order.
     * The user can add items, check out, or cancel the order.
     *
     * @param order The order currently being built
     */
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

    /**
     * The customer can select a signature sandwich and confirm whether
     * it should be added to the current order. Some signature sandwiches may
     * ask for additional choices, such as bread type.
     *
     * @param order The current order that the signature sandwich may be added to
     */
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

    /**
     * Builds a custom sandwich by prompting the customer for each sandwich option.
     * The completed sandwich is displayed for review before it is added to the order.
     *
     * @param order The current order that the sandwich may be added to
     */
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

    /**
     * Prompts the customer to select a bread type for the sandwich.
     * The method keeps asking until a valid bread option is selected.
     *
     * @param sandwich The sandwich being customized
     */
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

    /**
     * Prompts the customer to select a sandwich size.
     * If the customer cancels, true is returned so the sandwich building process can stop.
     *
     * @param sandwich The sandwich being customized
     * @return true if the customer cancels; false after a valid size is selected
     */
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

    /**
     * Prompts the customer to choose sandwich sides.
     * The customer may choose zero or more sides, and the loop continues
     * until the customer selects Done.
     *
     * @param sandwich The sandwich being customized
     */
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

    /**
     * Prompts the customer to choose whether the sandwich should be toasted.
     * The method keeps asking until the customer enters Yes or No.
     *
     * @param sandwich The sandwich being customized
     */
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

    /**
     * Prompts the customer to choose one cheese or no cheese.
     * If a cheese is selected, the customer is also asked whether they want extra cheese.
     *
     * @param sandwich The sandwich being customized
     */
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

    /**
     * Prompts the customer to choose one meat or no meat.
     * If meat is selected, the customer is also asked whether they want extra meat.
     *
     * @param sandwich The sandwich being customized
     */
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

    /**
     * Prompts the customer to choose sauces for the sandwich.
     * The customer may choose zero or more sauces, but duplicate sauces are not added.
     *
     * @param sandwich The sandwich being customized
     */
    private void addSauce(Sandwich sandwich) {
        boolean addingSauce = true;
        while (addingSauce) {
            System.out.println("\tWhat Sauces would you like?\n ");
            if (!sandwich.getSauces().contains(Sauces.MAYO)) {
                System.out.println("1) Mayo");
            }
            if (!sandwich.getSauces().contains(Sauces.MUSTARD)) {
                System.out.println("2) Mustard");
            }
            if (!sandwich.getSauces().contains(Sauces.KETCHUP)) {
                System.out.println("3) Ketchup");
            }
            if (!sandwich.getSauces().contains(Sauces.RANCH)) {
                System.out.println("4) Ranch");
            }
            if (!sandwich.getSauces().contains(Sauces.THOUSAND_ISLANDS)) {
                System.out.println("5) Thousand Islands");
            }
            if (!sandwich.getSauces().contains(Sauces.VINAIGRETTE)) {
                System.out.println("6) Vinaigrette");
            }
            System.out.println("0) Done or none\n");

            System.out.println("\tChoose an option");
            String sauceChoice = scanner.nextLine();

            switch (sauceChoice) {
                case "1":
                    if (!sandwich.getSauces().contains(Sauces.MAYO)) {
                        sandwich.addSauce(Sauces.MAYO);
                        System.out.println("Mayo Added!");
                    } else {
                        System.err.println("Mayo Already Added");
                    }
                    break;
                case "2":
                    if (!sandwich.getSauces().contains(Sauces.MUSTARD)) {
                        sandwich.addSauce(Sauces.MUSTARD);
                        System.out.println("Mustard Added!");
                    } else {
                        System.err.println("Mustard Already Added");
                    }
                    break;
                case "3":
                    if (!sandwich.getSauces().contains(Sauces.KETCHUP)) {
                        sandwich.addSauce(Sauces.KETCHUP);
                        System.out.println("Ketchup Added!");
                    } else {
                        System.err.println("Ketchup Already Added");
                    }
                    break;
                case "4":
                    if (!sandwich.getSauces().contains(Sauces.RANCH)) {
                        sandwich.addSauce(Sauces.RANCH);
                        System.out.println("Ranch Added!");
                    } else {
                        System.err.println("Ranch Already Added");
                    }
                    break;
                case "5":
                    if (!sandwich.getSauces().contains(Sauces.THOUSAND_ISLANDS)) {
                        sandwich.addSauce(Sauces.THOUSAND_ISLANDS);
                        System.out.println("Thousand Islands Added!");
                    } else {
                        System.err.println("Thousand Islands Already Added");
                    }
                    break;
                case "6":
                    if (!sandwich.getSauces().contains(Sauces.VINAIGRETTE)) {
                        sandwich.addSauce(Sauces.VINAIGRETTE);
                        System.out.println("Vinaigrette Added!");
                    } else {
                        System.err.println("Vinaigrette Already Added");
                    }
                    break;
                case "0":
                    addingSauce = false;
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
    /**
     * Prompts the customer to choose regular toppings for the sandwich.
     * The customer may choose zero or more toppings, but duplicate toppings are not added.
     *
     * @param sandwich The sandwich being customized
     */

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
                    tryToAddTopping(sandwich,Toppings.LETTUCE,"Lettuce");
                    break;
                case "2":
                    tryToAddTopping(sandwich,Toppings.PEPPERS,"Peppers");
                    break;
                case "3":
                    tryToAddTopping(sandwich,Toppings.ONIONS,"Onions");
                    break;
                case "4":
                    tryToAddTopping(sandwich,Toppings.TOMATOES,"Tomatoes");
                    break;
                case "5":
                    tryToAddTopping(sandwich,Toppings.JALAPENOS,"Jalapenos");
                    break;
                case "6":
                    tryToAddTopping(sandwich,Toppings.CUCUMBERS,"Cucumbers");
                    break;
                case "7":
                    tryToAddTopping(sandwich,Toppings.PICKLES,"Pickles");
                    break;
                case "8":
                    tryToAddTopping(sandwich, Toppings.GUACAMOLE, "Guacamole");
                    break;
                case "9":
                    tryToAddTopping(sandwich, Toppings.MUSHROOM, "Mushroom");
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

    /**
     * Convenience method to try to add a topping to a sandwich.  If the sandwich already has the topping, an error message
     * is displayed and the sandwich is unchanged.  If the sandwich doesn't ...
     *
     * @param sandwich    The sandwich to try to add the topping to
     * @param toppings    The topping to try to add
     * @param toppingName A user-friendly name for the topping
     */
    private void tryToAddTopping(Sandwich sandwich, Toppings toppings, String toppingName) {
        if (!sandwich.getToppings().contains(toppings)) {
            sandwich.addTopping(toppings);
            System.out.println(toppingName + " Added!\n");
        } else {
            System.err.println("You Already Added " + toppingName);
        }
    }

    /**
     * Prompts the customer to select a drink size.
     * The selected drink is displayed for review before being added to the order.
     *
     * @param order The current order that the drink may be added to
     */
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

    /**
     * Creates a chips item and asks the customer to confirm it.
     * Chips are only added to the order if the customer confirms.
     *
     * @param order The current order that the chips may be added to
     */
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