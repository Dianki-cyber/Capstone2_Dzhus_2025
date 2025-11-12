package org.example;

public enum SauceType {
    MAYO(1),
    MUSTARD(2),
    KETCHUP(3),
    RANCH(4),
    THOUSANDISLANDS(5),
    VINAIGRETTE(6);

    private final int code;

    SauceType(int code) {
        this.code = code;
    }
    public static SauceType sauceTypeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (SauceType sauceType :SauceType.values()) {
            //2. Check the custom integer code
            if (sauceType.code == code) {
                // 3.} Return the matching constant
                return sauceType;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);
    }

    static void display() {
        for (SauceType sauceType: SauceType.values()) {
            System.out.printf(" %-2d  %-15s \n",sauceType.code, sauceType.getTitle());
        }
    }
    public String getTitle() {
        return switch (this) {
            case MAYO -> "MAYO";
            case MUSTARD -> "MUSTARD";
            case KETCHUP -> "KETCHUP";
            case RANCH -> "RANCH";
            case THOUSANDISLANDS -> "THOUSANDISLANDS";
            case VINAIGRETTE -> "VINAIGRETTE";

        };
    }
}
