package org.example;

import java.util.ArrayList;
import java.util.List;


public class Sandwich {
    private  SandwichSize size;
    private  BreadType bread;
    private  MeatType toppingMeat;
    private  boolean extraMeat;
    private  CheeseType toppingCheese;
    private boolean extraCheese;
    private List<SauceType> sauceTypeList;
    private  List<Topping> toppings = new ArrayList<>();


    public Sandwich(SandwichSize sandwichSize, BreadType breadType, MeatType meatType, boolean isNeedextraMeat, CheeseType cheeseType, boolean isNeedExtraCheese, List<Topping> toppings, List<SauceType> sauceTypeList) {
        this.size = sandwichSize;
        this.bread = breadType;
        this.toppingMeat= meatType;
        this.extraMeat = isNeedextraMeat;
        this.toppingCheese = cheeseType;
        this.extraCheese = isNeedExtraCheese;
        this.toppings = toppings;
        this.sauceTypeList = sauceTypeList;
    }

    public BreadType getBread() {
        return bread;
    }

    public void setBread(BreadType bread) {
        this.bread = bread;
    }

    public MeatType getToppingMeat() {
        return toppingMeat;
    }

    public void setToppingMeat(MeatType toppingMeat) {
        this.toppingMeat = toppingMeat;
    }

    public CheeseType getToppingCheese() {
        return toppingCheese;
    }

    public void setToppingCheese(CheeseType toppingCheese) {
        this.toppingCheese = toppingCheese;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public List<SauceType> getSauceTypeList() {
        return sauceTypeList;
    }

    public void setSauceTypeList(List<SauceType> sauceTypeList) {
        this.sauceTypeList = sauceTypeList;
    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size= size;
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
        this.toppings = toppings;
    }

    // Calculate price
    public  double getPrice() {
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
    private void addTopping(Topping topping){
        toppings.add(topping);
    }

    @Override
    public String toString() {
        String sandwichString = "\n=== Sandwich ===\n" +
                "Bread: " + bread + "\n" +
                "Meat: " + toppingMeat + "\n" +
                "Cheese: " + toppingCheese + "\n";

        sandwichString += "Toppings:\n";
        for (Topping topping : toppings) {
            sandwichString += "  - " + topping.getTitle() + "\n";
        }

        sandwichString += "Sauces:\n";
        for (SauceType sauceType : sauceTypeList) {
            sandwichString += "  - " + sauceType.getTitle() + "\n";
        }

        return sandwichString;
    }}


