package org.example;

public enum MeatType {
    STEAK,
    HAM,
    SALAMI,
    ROASTBEEF,
    CHICKEN,
    BACON;
    public String toString(){
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
