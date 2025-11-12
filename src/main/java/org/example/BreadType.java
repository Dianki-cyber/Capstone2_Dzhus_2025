package org.example;

public enum BreadType {
    WHEAT(1),
    WHITE(2),
    RYE(3),
    WRAP(4);

    private final int code;
    static final double priceSmall= 5.50;
    static final double priceMedium = 7.00;
    static final double priceLarge = 8.50;

    BreadType(int code) {
        this.code = code;
    }
    public static BreadType breadTypeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (BreadType breadType : BreadType.values()) {
            //2. Check the custom integer code
            if (breadType.code == code) {
                // 3.} Return the matching constant
                return breadType;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);
    }

    public String getTitle() {
        return switch (this) {
            case WHEAT -> "WHEAT";
            case WHITE -> "WHITE";
            case RYE -> "RYE";
            case WRAP -> "WRAP";
            default -> "NO SANDWICH";
        };
    }
    static void display() {
        for (BreadType breadType: BreadType.values()) {
            System.out.printf(" %-2d  %-10s  %-10.2f %-10.2f %-10.2f\n",breadType.code, breadType.getTitle(), BreadType.priceSmall, BreadType.priceMedium, BreadType.priceLarge);
        }
    }
}
