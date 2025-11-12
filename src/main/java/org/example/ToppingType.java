package org.example;

public enum ToppingType {
    MEAT(1),
    CHEESE(2),
    LETTUCE(3),
   PEPPERS(4),
   ONIONS(5),
   TOMATOES(6),
  JALAPENOS(7),
   CUCUMBERS(8),
    PICKLES(9),
  GUACAMOLE(10),
    MUSHROOMS(11);

    private final int code;

    ToppingType(int code) {
        this.code = code;
    }
    public static ToppingType toppingTypeFromCode(int code) {
        // 1. Loop through all defined constants in the enum
        for (ToppingType toppingType : ToppingType.values()) {
            //2. Check the custom integer code
            if (toppingType.code == code) {
                // 3.} Return the matching constant
                return toppingType;
            }
        }
        // 4. Handle no match (crucial for robustness)
        throw new IllegalArgumentException("Unknown status code provided: " + code);
    }

        static void display() {
        for (ToppingType toppingType: ToppingType.values()) {
            System.out.printf(" %-2d  %-15s \n",toppingType.code, toppingType.getTitle());
        }
    }

    public String getTitle() {
        return switch (this) {
            case MEAT -> "MEAT";
            case CHEESE -> "CHEESE";
            case LETTUCE -> "LETTUCE";
            case PEPPERS -> "PEPPERS";
            case ONIONS -> "ONIONS";
            case TOMATOES -> "TOMATOES";
            case JALAPENOS -> "JALAPENOS";
            case CUCUMBERS -> "CUCUMBERS";
            case PICKLES -> "PICKLES";
            case GUACAMOLE -> "GUACAMOLE";
            case MUSHROOMS -> "MUSHROOMS";
          //  default -> "NO TOPPING";
        };
    }

}
