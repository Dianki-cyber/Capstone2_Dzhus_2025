package org.example;

public enum MeatType {
    STEAK(1),
    HAM(2),
    SALAMI(3),
    ROASTBEEF(4),
    CHICKEN(5),
    BACON(6);
    private final int code;
    static final double priceSmall= 1.00;
    static final double priceMedium = 2.00;
    static final double priceLarge = 3.00;

    MeatType(int code) {
        this.code = code;
    }
    public static MeatType meatTypeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (MeatType meatType : MeatType.values()) {
            //2. Check the custom integer code
            if (meatType.code == code) {
                // 3.} Return the matching constant
                return meatType;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);

    }
    static void display() {
        for (MeatType meatType: MeatType.values()) {
            System.out.printf(" %-2d  %-15s  %-15.2f %-15.2f %-15.2f\n",meatType.code, meatType.getTitle(), MeatType.priceSmall, MeatType.priceMedium, MeatType.priceLarge);
        }
    }
    public String getTitle(){
        return switch (this) {
            case STEAK -> "STEAK";
            case HAM -> "HAM";
            case SALAMI -> "SALAMI";
            case ROASTBEEF -> "ROASTBEEF";
            case CHICKEN -> "CHICKEN";
            case BACON -> "BACON";
            //default -> "NO MEAT";
        };
    }

}
