package org.example;

public enum CheeseType {
    AMERICAN(1),
    PROVOLONE(2),
    CHEDDAR(3),
    SWISS(4);

    private final int code;
    static final double priceSmall = 0.75;
    static final double priceMedium = 1.50;
    static final double priceLarge = 2.25;

    CheeseType(int code) {
        this.code = code;
    }

    public static CheeseType cheeseTypeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (CheeseType cheeseType : CheeseType.values()) {
            //2. Check the custom integer code
            if (cheeseType.code == code) {
                // 3.} Return the matching constant
                return cheeseType;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);
    }

    static void display() {
        for (CheeseType cheeseType : CheeseType.values()) {
            System.out.printf(" %-2d  %-15s  %-15.2f %-15.2f %-15.2f\n", cheeseType.code, cheeseType.getTitle(), CheeseType.priceSmall, CheeseType.priceMedium, CheeseType.priceLarge);
        }
    }

    public String getTitle() {
        return switch (this) {
            case AMERICAN -> "AMERICAN";
            case PROVOLONE -> "PROVOLONE";
            case CHEDDAR -> "CHEDDAR";
            case SWISS -> "SWISS";
            //default -> "NO cheese";
        };
    }
    public  static  double priceForSize(int size){
        if(size==1) {
            return priceSmall;
        } else if (size==2){
            return  priceMedium;
        } else {
            return  priceLarge;
        }

    }
}

