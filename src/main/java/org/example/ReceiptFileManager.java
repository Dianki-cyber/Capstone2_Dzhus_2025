package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ReceiptFileManager {
    private static final String RECEIPT_FOLDER = "src/main/resources/receipts/";
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    private ReceiptFileManager() {
        // Private constructor to prevent instantiation
    }

    public static void writeReceipt(Order order) {
        String receiptName = generateReceiptName();
        File folder = new File(RECEIPT_FOLDER);
        if (!folder.exists()) {
            boolean created = folder.mkdirs();
            if (!created) {
                System.err.println("Warning: could not create receipts folder at " + folder.getAbsolutePath());
            }
        }

        File file = new File(RECEIPT_FOLDER + receiptName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("Receipt - " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\n");
            writer.write("------------------------------------------------\n");

            writeSandwiches(writer, order);
            writeDrinks(writer, order);
            writeChips(writer, order);

            writer.write("------------------------------------------------\n");
            writer.write(String.format("TOTAL: $%.2f%n", order.getTotalPrice()));
            System.out.println("\nReceipt written to: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error writing receipt: " + e.getMessage());
        }
    }

    private static String generateReceiptName() {
        return "Receipt_" + LocalDateTime.now().format(FILE_NAME_FORMATTER) + ".txt";
    }

    private static void writeSandwiches(BufferedWriter writer, Order order) throws IOException {
        if (!order.getSandwiches().isEmpty()) {
            writer.write("Sandwiches:\n");
            for (int i = order.getSandwiches().size() - 1; i >= 0; i--) {
                Sandwich sandwich = order.getSandwiches().get(i);
                writer.write(String.format(" - %s %s Sandwich%n", sandwich.getSize(), getBreadName(sandwich)));
                writeSandwichIngredients(writer, sandwich);
                writer.write(String.format("   Price: $%.2f%n%n", sandwich.getPrice()));
            }
        }
    }

    private static void writeDrinks(BufferedWriter writer, Order order) throws IOException {
        if (!order.getDrinks().isEmpty()) {
            writer.write("Drinks:\n");
            Map<String, Integer> drinkCounts = new HashMap<>();
            order.getDrinks().forEach(d -> drinkCounts.merge(d.getName(), 1, Integer::sum));

            for (Map.Entry<String, Integer> entry : drinkCounts.entrySet()) {
                Drink drink = order.getDrinks().stream()
                        .filter(d -> d.getName().equals(entry.getKey()))
                        .findFirst()
                        .orElse(null);
                if (drink != null) {
                    double totalPrice = drink.getPrice() * entry.getValue();
                    writer.write(String.format(" - %s (x%d) - Each: $%.2f, Total: $%.2f%n",
                            entry.getKey(), entry.getValue(), drink.getPrice(), totalPrice));
                }
            }
        }
    }

    private static void writeChips(BufferedWriter writer, Order order) throws IOException {
        if (!order.getChips().isEmpty()) {
            writer.write("Chips:\n");
            Map<String, Integer> chipCounts = new HashMap<>();
            order.getChips().forEach(c -> chipCounts.merge(c.getName(), 1, Integer::sum));

            for (Map.Entry<String, Integer> entry : chipCounts.entrySet()) {
                Chips chip = order.getChips().stream()
                        .filter(c -> c.getName().equals(entry.getKey()))
                        .findFirst()
                        .orElse(null);
                if (chip != null) {
                    double totalPrice = chip.getPrice() * entry.getValue();
                    writer.write(String.format(" - %s (x%d) - Each: $%.2f, Total: $%.2f%n",
                            entry.getKey(), entry.getValue(), chip.getPrice(), totalPrice));
                }
            }
        }
    }

    private static String getBreadName(Sandwich sandwich) {
        return sandwich.getBreadType().getTitle();
    }

    private static void writeSandwichIngredients(BufferedWriter writer, Sandwich sandwich) throws IOException {
        writer.write(String.format("      %s: $%.2f%n",
                sandwich.getToppingMeat().getTitle(),
                MeatType.priceForSize(sandwich.getSize().getCode())));

        writer.write(String.format("      %s: $%.2f%n",
                sandwich.getToppingCheese().getTitle(),
                CheeseType.priceForSize(sandwich.getSize().getCode())));

        if (!sandwich.getToppings().isEmpty()) {
            writer.write("   Toppings:\n");
            for (Topping topping : sandwich.getToppings()) {
                writer.write("      - " + topping.getTitle() + "\n");
            }
        }

    }
}



