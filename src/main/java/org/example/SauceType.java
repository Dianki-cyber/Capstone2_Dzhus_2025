package org.example;

public enum SauceType {
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSANDISLANDS,
    VINAIGRETTE;

    public String toString() {
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
