package org.example;

public enum SandwichSize { 
    SMALL ,
    MEDIUM,
    LARGE ;
    public String toString() {
        return switch (this) {
            case SMALL -> "4 inch";
            case MEDIUM -> "8 inch";
            case LARGE -> "12 inch";
            default -> "0 inch";
        };
    }

}
