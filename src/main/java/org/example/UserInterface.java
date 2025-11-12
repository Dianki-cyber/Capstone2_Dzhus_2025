package org.example;



import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private SandwichShop sandwichShop;

    public UserInterface() {
        init();
    }

    private List<Sandwich> sandwiches = new ArrayList<>();

    private void init() {
        this.sandwichShop = new SandwichShop("Delicious");
    }

    private void logMenu() {
        System.out.printf("Welcome to %s,we sell the best sandwiches! ", this.sandwichShop.getName());
        System.out.println("\n Select from the following options:");
        System.out.println("0. Exit Program");
        System.out.println("1. New order");
        System.out.print("Enter choice: ");
    }

    public void start() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            logMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();//always put this
                switch (choice) {
                    case 1 -> showOrderScreen(scanner);
                    case 0 -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Wrong choice. Try again!");
                }
            } catch (InputMismatchException exception) {
                System.out.println("Invalid input");
                scanner.nextLine();
            } catch (Exception exception) {
                System.out.println("Invalid input try again");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private void showOrderScreen(Scanner scanner) {
        boolean inOrder = true;

        while (inOrder) {
            System.out.println();
            System.out.println("=== Order ===");
            // Menu options required by the project
            System.out.println();
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();
            int i = 1;
            for (Sandwich sandwich : this.sandwiches) {
                System.out.println(i + ". " + sandwich);
                i++;
            }


            switch (choice) {
                case "1":
                    addSandwich(scanner);
                    break;
                case "2":
                    addDrink(scanner);
                    break;
                case "3":
                     addChips(scanner);
                    break;
                case "4":
                     checkedOut(scanner);
                     inOrder = false;
                    //  receiptPrint
                    break;
                case "0":
                    //sandwiches.clear();  // delete order
                    System.out.println("Order cancelled.");
                    inOrder = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addSandwich(Scanner scanner) {
        SandwichBuilder builder = new SandwichBuilder(scanner);
        Sandwich sandwich = builder.build();
        sandwiches.add(sandwich);
    }
    private  void addDrink(Scanner scanner){
        //drinks
        System.out.println("Would you like a drink? Yes/ no ");
        showDrinks();
        String answer2 = scanner.nextLine();
        boolean isNeedDrink = false;
        int drinkSize;
        if (answer2.equalsIgnoreCase("Yes")) {
            isNeedDrink = true;
            System.out.println("What size?");
            drinkSize = scanner.nextInt();
            scanner.nextLine();
        }

    }
    private void showDrinks() {
        System.out.println("\nChoose your size:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#","","Small", "Medium", "Large");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "", "", "$2.00", "$2,50", "$3.00");
        System.out.println("------------------------------------");
    }

    private  void addChips(Scanner scanner){
        System.out.println("Would you like a chips? Yes/no");
        String answer3 = scanner.nextLine();
        boolean isChipsNeeded = false;
        if (answer3.equalsIgnoreCase("Yes")){
            isChipsNeeded=true;
        }
    }
    private void checkedOut(Scanner scanner) {
        System.out.println("Would you like to continue your order? (yes/no)");
        String answer = scanner.nextLine().trim();

        if (answer.equalsIgnoreCase("yes")) {
        } else {
            System.out.println("Printing your receipt...");

        }
    }


}




