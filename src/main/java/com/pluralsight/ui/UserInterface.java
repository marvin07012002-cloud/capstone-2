package com.pluralsight.ui;

import com.pluralsight.models.*;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);

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
                System.out.println("\t▄▖     ▌  ▄       ▌\n" +
                        "\t▌ ▛▌▛▌▛▌  ▙▘▌▌█▌  ▌\n" +
                        "\t▙▌▙▌▙▌▙▌  ▙▘▙▌▙▖  ▖\n" +
                        "            \t▄▌     ");

            } else {
                System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                        "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                        "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                        "                              ");
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
                                           1) Add Sandwich
                                           2) Add Drink
                                           3) Add Chips
                                           4) Checkout
                                           0) Cancel Order
                    
                                          Choose an option.
                    
                    
                    """);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addSandwichToOrder(order);
                    break;
                case "2":
                    addDrinkToOrder(order);
                    break;
                case "3":
                    addChipsToOrder(order);
                    break;
                case "4":
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
                                System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                                        "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                                        "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                                        "                              ");
                            }
                        }
                    }
                    break;

                case "0":
                    System.err.println("\tOrder Cancelled");
                    return;
                default:
                    System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                            "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                            "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                            "                              ");
            }
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
                    System.err.println("\t▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                            "\t▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                            "\t▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                            "                              ");
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
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");
            }
        }
        boolean choosing = true;
        while (choosing == true) {
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
                    return;
                default:
                    System.err.println("███████╗███████╗██╗     ███████╗ ██████╗████████╗     █████╗ ███╗   ██╗     ██████╗ ██████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n" +
                            "██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔══██╗████╗  ██║    ██╔═══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n" +
                            "███████╗█████╗  ██║     █████╗  ██║        ██║       ███████║██╔██╗ ██║    ██║   ██║██████╔╝   ██║   ██║██║   ██║██╔██╗ ██║\n" +
                            "╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██╔══██║██║╚██╗██║    ██║   ██║██╔═══╝    ██║   ██║██║   ██║██║╚██╗██║\n" +
                            "███████║███████╗███████╗███████╗╚██████╗   ██║       ██║  ██║██║ ╚████║    ╚██████╔╝██║        ██║   ██║╚██████╔╝██║ ╚████║\n" +
                            "╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝       ╚═╝  ╚═╝╚═╝  ╚═══╝     ╚═════╝ ╚═╝        ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n" +
                            "                                                                                                                           ");

            }
            if(!(sandwich.getMeat() == null)) {
                while (true) {
                    System.out.println(" Would you like extra meat? Yes/No");
                    String chooice = scanner.nextLine();
                    if (chooice.equalsIgnoreCase("yes")) {
                        sandwich.setExtraMeat(true);
                        break;
                    } else if (choice.equalsIgnoreCase("no")) {
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


        // add cheese
        // other things

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