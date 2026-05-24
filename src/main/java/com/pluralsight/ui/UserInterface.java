package com.pluralsight.ui;

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
                System.out.println("▄▖     ▌  ▄       ▌\n" +
                        "▌ ▛▌▛▌▛▌  ▙▘▌▌█▌  ▌\n" +
                        "▙▌▙▌▙▌▙▌  ▙▘▙▌▙▖  ▖\n" +
                        "            ▄▌     ");

            } else {
                System.err.println("▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                        "▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                        "▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
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
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    if(order.isEmpty()){
                        System.err.println("\tYou must at least add one item before check out.");
                    }else {
                        order.displayOrderDetails();
                        System.out.println("Confirm Check out? Yes/No: ");
                        String confirm = scanner.nextLine();

                        if(confirm.equalsIgnoreCase("Yes")){
                            order.saveReceipt();
                            return;
                        } else if (confirm.equalsIgnoreCase("No")) {
                            return;
                        }else {
                            System.err.println("▄▖▖ ▖▖▖▄▖▖ ▄▖▄   ▄▖▄▖▄▖▄▖▄▖▖ ▖\n" +
                                    "▐ ▛▖▌▌▌▌▌▌ ▐ ▌▌  ▌▌▙▌▐ ▐ ▌▌▛▖▌\n" +
                                    "▟▖▌▝▌▚▘▛▌▙▖▟▖▙▘  ▙▌▌ ▐ ▟▖▙▌▌▝▌\n" +
                                    "                              ");
                        }
                    }
                    break;




            }
        }
    }
}