package org.example;

public enum ToppingType {
    MEAT,
    CHEESE,
    LETTUCE,
   PEPPERS,
   ONIONS,
   TOMATOES,
  JALAPENOS,
   CUCUMBERS,
    PICKLES,
  GUACAMOLE,
    MUSHROOMS;
    public String toString() {
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
