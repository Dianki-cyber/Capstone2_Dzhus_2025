package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sandwich {
    private static SandwichSize size;
    private  BreadType bread;
    private  MeatType toppingMeat;
    private static boolean extraMeat;
    private  CheeseType toppingCheese;
    private static boolean extraCheese;
    private static List<SauceType> sauceTypeList;
    private static List<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType bread, MeatType toppingMeat, boolean extraMeat, CheeseType toppingCheese, boolean extraCheese, List<SauceType> sauceTypeList, List<Topping> toppings) {
        this.size = size;
        this.bread = bread;
        this.toppingMeat= toppingMeat;
        this.extraMeat = extraMeat;
        this.toppingCheese = toppingCheese;
        this.extraCheese = extraCheese;
        this.sauceTypeList = sauceTypeList;
        this.toppings = toppings;
    }

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, MeatType meatType, boolean isNeedextraMeat, CheeseType cheeseType, boolean isNeedExtraCheese, ArrayList<ToppingType> toppings, List<SauceType> sauceTypeList) {

        Sandwich.sauceTypeList = sauceTypeList;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        Sandwich.size = size;
    }

    public BreadType getBreadType() {
        return bread;
    }

    public void setBreadType(BreadType bread) {
        this.bread = bread;
    }


    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        Sandwich.toppings = toppings;
    }

    // Calculate price
    public static double getPrice() {
        double total = 0.0;

        // Add base price depending on size
        switch (size) {
            case SMALL -> total += 5.0;
            case MEDIUM -> total += 7.0;
            case LARGE -> total += 9.0;
        }

        // Extra meat/cheese cost
        if (extraMeat) total += 2.0;
        if (extraCheese) total += 1.5;

        // Price of toppings
        if (toppings != null) {
            total += toppings.size() * 0.5;
        }

        // Price of sauces
        if (sauceTypeList != null) {
            total += sauceTypeList.size() * 0.25;
        }

        return total;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "bread=" + bread +
                ", toppingMeat=" + toppingMeat +
                ", toppingCheese=" + toppingCheese +
                '}';
    }
}


