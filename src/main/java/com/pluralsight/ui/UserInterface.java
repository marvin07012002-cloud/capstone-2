package com.pluralsight.ui;

import com.pluralsight.models.Chips;
import com.pluralsight.models.Order;

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
    }

    private void addDrinkToOrder(Order order) {
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