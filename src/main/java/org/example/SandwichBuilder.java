package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class SandwichBuilder {
    private Scanner scanner;

    public SandwichBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich build() {

        System.out.println("Please choose your size: 1 - 4inch,2 - 8inch,3 - 12inch");
        int size = scanner.nextInt();
        scanner.nextLine();
        SandwichSize sandwichSize = SandwichSize.sandwichSizeFromCode(size);


        System.out.println("Please choose your bread :");
        showBreadMenu();
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();
        BreadType breadType = BreadType.breadTypeFromCode(breadChoice);

        // toppings
        showToppingsMenu();
        int toppingMeat = scanner.nextInt();
        scanner.nextLine();
        MeatType meatType = MeatType.meatTypeFromCode(toppingMeat);

        //extra meat
        System.out.println("Would you like extra meat? Yes/No");
        showExtraMeat();
        String answer = scanner.nextLine();
        boolean isNeedextraMeat = !answer.equalsIgnoreCase("No");

        //cheese
        showCheeseMenu();
        int cheese = scanner.nextInt();
        scanner.nextLine();
        CheeseType cheeseType = CheeseType.cheeseTypeFromCode(cheese);

        //extra cheese
        System.out.println("Would you like extra cheese? Yes/No");
        showExtraCheese();
        String answer1 = scanner.nextLine();
        boolean isNeedExtraCheese = !answer1.equalsIgnoreCase("No");

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
        ArrayList<ToppingType> toppings = new ArrayList<>();
        for (Integer item : regularToppings) {
            ToppingType toppingType = ToppingType.toppingTypeFromCode(item);
            toppings.add(toppingType);
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
        ArrayList<SauceType> sauceTypes = new ArrayList<>();
        for (Integer item : regularSauces) {
            SauceType sauceType = SauceType.sauceTypeFromCode(item);
            sauceTypes.add(sauceType);


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

     
        return new Sandwich(sandwichSize,breadType,meatType,isNeedextraMeat,cheeseType,isNeedExtraCheese,toppings,sauceTypes);
    }




    private void showBreadMenu() {
        System.out.println("\nChoose your bread type:");
        System.out.println("------------------------------------");
        System.out.printf(" %-2s  %-10s  %-10s %-10s %-10s\n", "#", "Bread Type", "4\"","8\"","12\"");
        System.out.println("------------------------------------");
        BreadType.display();
        System.out.println("------------------------------------");
    }

    private void showToppingsMenu() {
        System.out.println("\nChoose your toppings:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s %-8s %-8s %-8s\n", "#", "Topping", "4\"", "8\"", "12\"");
        System.out.println("------------------------------------");
        MeatType.display();
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
        CheeseType.display();
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
        ToppingType.display();
        System.out.printf("%-3s \n",  " 0.Finish with regular toppings");
        System.out.println("------------------------------------");
    }

    private void showRegularSauces() {
        System.out.println("\nChoose your regular sauces:");
        System.out.println("------------------------------------");
        System.out.printf("%-3s %-15s\n", "#", "Sauces");
        System.out.println("------------------------------------");
        SauceType.display();
        System.out.printf("%-3s %-15s\n", "0", "Finish with regular sauces");
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