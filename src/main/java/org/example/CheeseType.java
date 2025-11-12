package org.example;

public enum CheeseType {
    AMERICAN,
    PROVOLONE,
    CHEDDAR,
    SWISS;
    public String toString() {
        return switch (this) {
            case AMERICAN -> "AMERICAN";
            case PROVOLONE -> "PROVOLONE";
            case CHEDDAR -> "CHEDDAR";
            case SWISS -> "SWISS";
            //default -> "NO cheese";
        };
}   }
