package org.example;

public class Topping {
    private ToppingType type;
    private  MeatType meatType;
    private double price;
    private  boolean isPremium;

    public Topping( ToppingType type, double price) {
        this.type = type ;
        this.price = price;
    }
    public ToppingType getType() {
        return type;
    }

    public void setType(ToppingType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Topping{" +
                "name='" + type.toString() + '\'' +
                ", price=" + price +
                '}';
    }
}
