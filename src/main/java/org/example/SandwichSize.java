package org.example;

public enum SandwichSize { 
    SMALL(1) ,
   MEDIUM(2),
    LARGE(3);
    private final int code;

    SandwichSize(int code) {
        this.code = code;
    }
    public static SandwichSize sandwichSizeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            //2. Check the custom integer code
            if (sandwichSize.code == code) {
                // 3.} Return the matching constant
                return sandwichSize;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);

    }

    public String getTitle() {
        return switch (this) {
            case SMALL -> "4 inch";
            case MEDIUM -> "8 inch";
            case LARGE -> "12 inch";
            default -> "0 inch";
        };

    }
}
