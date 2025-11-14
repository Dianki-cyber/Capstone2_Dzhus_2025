package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SandwichBuilder {
    private Scanner scanner;

    public SandwichBuilder(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich build() {

        System.out.println();
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║      📏  CHOOSE YOUR SANDWICH SIZE ║");
        System.out.println("╚══════════════════════════════════╝");
        System.out.println();
        System.out.println("  1️⃣  4 inch");
        System.out.println("  2️⃣  8 inch");
        System.out.println("  3️⃣  12 inch");
        System.out.println("------------------------------------");
        System.out.print("Enter your choice ➤ ");

        int size = scanner.nextInt();
        scanner.nextLine();
        SandwichSize sandwichSize = SandwichSize.sandwichSizeFromCode(size);
        System.out.println(sandwichSize);

        System.out.println("Please choose your bread :");
        showBreadMenu();
        System.out.print("Enter your choice: ");
        int breadChoice = scanner.nextInt();
        scanner.nextLine();
        BreadType breadType = BreadType.breadTypeFromCode(breadChoice);
        System.out.println(breadType);

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
        ArrayList<Topping> toppings = new ArrayList<>();
        for (Integer item : regularToppings) {
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

        List<Topping> toppingsToAdd = new ArrayList<>();

        for (Integer toppingCode : regularToppings) {
            toppingsToAdd.add(Topping.toppingFromCode(toppingCode));
        }

        System.out.print("\nWould you like the sandwich toasted? Yes/No: ");
        String toastedAnswer = scanner.nextLine().trim();
        boolean toasted = toastedAnswer.equalsIgnoreCase("Yes");
        return new Sandwich(sandwichSize, breadType, meatType, isNeedextraMeat, cheeseType, isNeedExtraCheese, toppingsToAdd, sauceTypes);
    }

    private void showBreadMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              CHOOSE YOUR BREAD TYPE             ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "#", "Bread Type", "4\"", "8\"", "12\"");
        System.out.println("--------------------------------------------------");
        BreadType.display();
        System.out.println("--------------------------------------------------");
    }

    private void showToppingsMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              CHOOSE YOUR TOPPINGS              ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "#", "Topping", "4\"", "8\"", "12\"");
        System.out.println("--------------------------------------------------");
        MeatType.display();
        System.out.println("--------------------------------------------------");
    }

    private void showExtraMeat() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                EXTRA MEAT OPTIONS               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "#", "Extra Meat", "4\"", "8\"", "12\"");
        System.out.println("--------------------------------------------------");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "", "", "$0.50", "$1.00", "$1.50");
        System.out.println("--------------------------------------------------");
    }

    private void showCheeseMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                CHOOSE YOUR CHEESE               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "#", "Cheese", "4\"", "8\"", "12\"");
        System.out.println("--------------------------------------------------");
        CheeseType.display();
        System.out.println("--------------------------------------------------");
    }

    private void showExtraCheese() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║               EXTRA CHEESE OPTIONS              ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "#", "Extra Cheese", "4\"", "8\"", "12\"");
        System.out.println("--------------------------------------------------");
        System.out.printf(" %-3s %-15s %-10s %-10s %-10s%n", "", "", "$0.30", "$0.60", "$0.90");
        System.out.println("--------------------------------------------------");
    }

    private void showRegularTopping() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║             CHOOSE YOUR REGULAR TOPPINGS        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s%n", "#", "Topping");
        System.out.println("--------------------------------------------------");
        Topping.display();
        System.out.println("--------------------------------------------------");
        System.out.println("  0  Finish with regular toppings");
        System.out.println("--------------------------------------------------");
    }

    private void showRegularSauces() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                CHOOSE YOUR SAUCES               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s%n", "#", "Sauces");
        System.out.println("--------------------------------------------------");
        SauceType.display();
        System.out.println("--------------------------------------------------");
        System.out.println("  0  Finish with regular sauces");
        System.out.println("--------------------------------------------------");
    }

    private void showSides() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║                 CHOOSE YOUR SIDES               ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.printf(" %-3s %-15s%n", "#", "Sides");
        System.out.println("--------------------------------------------------");
        System.out.printf(" %-3s %-15s%n", "1", "Au jus");
        System.out.printf(" %-3s %-15s%n", "2", "Sauce");
        System.out.printf(" %-3s %-15s%n", "0", "Finish with sides");
        System.out.println("--------------------------------------------------");
    }
}