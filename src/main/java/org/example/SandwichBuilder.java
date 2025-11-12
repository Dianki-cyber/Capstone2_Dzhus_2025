package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class SandwichBuilder {
    private Scanner scanner;

    public SandwichBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich build() {
        System.out.println("Please choose your bread :");
        showBreadMenu();
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();


        showSizeMenu();
        int size = scanner.nextInt();
        scanner.nextLine();

        // toppings
        showToppingsMenu();
        int topping = scanner.nextInt();
        scanner.nextLine();

        //extra meat
        System.out.println("Would you like extra meat? Yes/No");
        showExtraMeat();
        String answer = scanner.nextLine();
        boolean isNeedextraMeat = true;
        if (answer.equalsIgnoreCase("No")) {
            isNeedextraMeat = false;
        }

        //cheese
        showCheeseMenu();
        int cheese = scanner.nextInt();
        scanner.nextLine();

        //extra cheese
        System.out.println("Would you like extra cheese? Yes/No");
        showExtraCheese();
        String answer1 = scanner.nextLine();
        boolean isNeedExtraCheese = true;
        if (answer1.equalsIgnoreCase("No")) {
            isNeedExtraCheese = false;
        }

        //regular topping
        showRegularTopping();
        boolean procced = true;
        ArrayList<Integer> regularToppings = new ArrayList<Integer>();
        while (procced) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                procced = false;
            } else {
                regularToppings.add(choice);
            }
        }
        for (Integer item : regularToppings) {
            System.out.printf("%s, ", item);
        }

        //sauces
        showRegularSauces();
        boolean procced1 = true;
        ArrayList<Integer> regularSauces = new ArrayList<>();
        while (procced1) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                procced1 = false;
            } else {
                regularSauces.add(choice);
            }
        }
        for (Integer item : regularSauces) {
            System.out.printf("%s, ", item);

        }
        //sides
        showSides();
        boolean procced3 = true;
        ArrayList<Integer> sides = new ArrayList<>();
        while (procced3) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                procced3 = false;
            } else {
                sides.add(choice);
            }
        }
        for (Integer item : sides) {
            System.out.printf("%s, ", item);
        }




        return new Sandwich();
    }

    private void showBreadMenu() {
        System.out.println("\nChoose your bread type:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-10s\n", "#", "Bread Type", "Price");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-10s\n", "1.", "White", "$0.00");
        System.out.printf("%-3s %-15s %-10s\n", "2.", "Wheat", "$0.00");
        System.out.printf("%-3s %-15s %-10s\n", "3.", "Rye", "$0.00");
        System.out.printf("%-3s %-15s %-10s\n", "4.", "Wrap", "$0.00");
        System.out.println("------------------------------------");
    }

    private void showSizeMenu() {
        System.out.println("\nChoose your sandwich size:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-10s %-10s\n", "#", "Size", "Price");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-10s %-10s\n", "1.", "4\"", "$5.50");
        System.out.printf("%-3s %-10s %-10s\n", "2.", "8\"", "$7.00");
        System.out.printf("%-3s %-10s %-10s\n", "3.", "12\"", "$8.50");
        System.out.println("------------------------------------");

    }

    private void showToppingsMenu() {
        System.out.println("\nChoose your toppings:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#", "Topping", "4\"", "8\"", "12\"");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "1.", "Steak", "$1.00", "$2.00", "$3.00");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "2.", "Ham", "$0.75", "$1.50", "$2.25");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "4.", "Roast Beef", "$1.20", "$2.40", "$3.60");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "5.", "Chicken", "$1.00", "$2.00", "$3.00");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "6.", "Bacon", "$0.90", "$1.80", "$2.70");
        System.out.println("------------------------------------");
    }

    private void showExtraMeat() {
        System.out.println("\nChoose extra meat:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#", "Extra meat", "4\"", "8\"", "12\"");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "", "", "$0.50", "$1.00", "$1.50");
        System.out.println("------------------------------------");
    }

    private void showCheeseMenu() {
        System.out.println("\nChoose your cheese:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#", "Cheese", "4\"", "8\"", "12\"");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "1.", "American", "$0.75", "$1.50", "$2.25");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "2.", "Provolone", "$0.75", "$1.50", "$2.25");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "3.", "Cheddar", "$0.75", "$1.50", "$2.25");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "4.", "Swiss", "$0.75", "$1.50", "$2.25");
        System.out.println("------------------------------------");
    }

    private void showExtraCheese() {
        System.out.println("\nChoose extra cheese:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#", "Extra cheese", "4\"", "8\"", "12\"");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "", "", "$0.30", "$0.60", "$0.90");
        System.out.println("------------------------------------");
    }

    private void showRegularTopping() {
        System.out.println("\nChoose your regular toppings:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "#", "Topping");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "1.", "Lettuce");
        System.out.printf("%-3s %-15s\n", "2.", "Peppers");
        System.out.printf("%-3s %-15s\n", "3.", "Onions");
        System.out.printf("%-3s %-15s\n", "4.", "Tomatoes");
        System.out.printf("%-3s %-15s\n", "5.", "Jalapeños");
        System.out.printf("%-3s %-15s\n", "6.", "Cucumbers");
        System.out.printf("%-3s %-15s\n", "7.", "Pickles");
        System.out.printf("%-3s %-15s\n", "8.", "Guacamole");
        System.out.printf("%-3s %-15s\n", "9.", "Mushrooms");
        System.out.printf("%-3s %-15s\n", "0.", "Finish with regular toppings");
        System.out.println("------------------------------------");
    }

    private void showRegularSauces() {
        System.out.println("\nChoose your regular sauces:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "#", "Sauces");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "1.", "Mayo");
        System.out.printf("%-3s %-15s\n", "2.", "Mustard");
        System.out.printf("%-3s %-15s\n", "3.", "Ketchup");
        System.out.printf("%-3s %-15s\n", "4.", "Ranch");
        System.out.printf("%-3s %-15s\n", "5.", "Thousand islands");
        System.out.printf("%-3s %-15s\n", "6.", "Vinaigrette");
        System.out.printf("%-3s %-15s\n", "0.", "Finish with regular sauces");
        System.out.println("------------------------------------");
    }

    private void showSides() {
        System.out.println("\nChoose your sides :");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "#", "Sides");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "1.", "Au jus");
        System.out.printf("%-3s %-15s\n", "2.", "Sauce");
        System.out.printf("%-3s %-15s\n", "0.", "Finish with sides");

    }


}