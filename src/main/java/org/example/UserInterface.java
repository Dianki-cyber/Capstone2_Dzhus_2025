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
    private  List<Drink> drinks = new ArrayList<>();
    private  List<Chips> chips = new ArrayList<>();

    private void init() {
        this.sandwichShop = new SandwichShop("Delicious");
    }

    private void logMenu() {
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.printf ("║   🍞  Welcome to %-35s ║%n", this.sandwichShop.getName());
        System.out.println(  "║        We sell the best sandwiches in town!            ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        System.out.println("\nPlease select from the following options:");
        System.out.println("------------------------------------------------------------");
        System.out.println("  0. Exit Program");
        System.out.println("  1. New Order");
        System.out.println("------------------------------------------------------------");
        System.out.print("Enter your choice ➤ ");

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
        int orderNumber = 1;
        while (inOrder) {
            System.out.println();
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║            🧾  ORDER MENU         ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.println();

            System.out.println("  1️⃣  Add Sandwich");
            System.out.println("  2️⃣  Add Drink");
            System.out.println("  3️⃣  Add Chips");
            System.out.println("  4️⃣  Checkout");
            System.out.println("  0️⃣  Cancel Order");

            System.out.println("------------------------------------");
            System.out.print("Enter your choice ➤ ");

            String choice = scanner.nextLine();
            for (int i = sandwiches.size() - 1; i >= 0; i--) {
                System.out.println((sandwiches.size() - i) + " " + sandwiches.get(i));
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
                    Order order = new Order(orderNumber,sandwiches,drinks,chips);
                     checkedOut(order);
                     inOrder = false;
                     orderNumber++;
                    //  receiptPrint
                    break;
                case "0":
                    sandwiches.clear();
                    drinks.clear();
                    chips.clear();
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
        System.out.println(sandwich.getSize());
    }
    private  void addDrink(Scanner scanner) {
        //drinks
        System.out.println("Enter drink name :? ");
        String drinkName = scanner.nextLine();
        showDrinks();
        int drinkSize;
        drinkSize = scanner.nextInt();
        scanner.nextLine();
        Drink drink = new Drink(drinkName, drinkSize);
        drinks.add(drink);
        String sizeText = (drinkSize == 1) ? "Small" : (drinkSize == 2) ? "Medium" : "Large";
        System.out.printf("Added to your order: %s (%s) - $%.2f%n", drink.getName(), sizeText, drink.getPrice());
    }

    private void showDrinks() {
        System.out.println("\nChoose your size or exit : 0-exit , 1- small, 2- medium, 3- large");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#","","Small", "Medium", "Large");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "", "", "$2.00", "$2.50", "$3.00");
        System.out.println("------------------------------------");
    }

    private void addChips(Scanner scanner) {
        System.out.print("Would you like chips? Yes/No: ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("Yes")) {
            System.out.print("Enter chip type (e.g., BBQ, Salted): ");
            String chipName = scanner.nextLine();

            Chips chip = new Chips(); // Make sure your Chips class has getPrice() method
            chips.add(chip);

            System.out.printf("Added to your order: %s - $%.2f%n", chip.getName(), chip.getPrice());
        } else {
            System.out.println("No chips added to your order.");
        }
    }

    private void checkedOut(Order order) {
            System.out.println("Printing your receipt...");
           System.out.printf("Your total: %2.2f", order.getTotalPrice());
        }
    }





