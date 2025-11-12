package org.example;

public enum BreadType {
    WHEAT(1),
    WHITE(2),
    RYE(3),
    WRAP(4);

    private final int code;

    BreadType(int code) {
        this.code = code;
    }
    public static BreadType fromCode(int code) {
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

    public String toString() {
        return switch (this) {
            case WHEAT -> "WHEAT";
            case WHITE -> "WHITE";
            case RYE -> "RYE";
            case WRAP -> "WRAP";
            default -> "NO SANDWICH";
        };
    }
}
