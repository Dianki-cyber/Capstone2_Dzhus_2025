package org.example;

public class ToppingMain {
    private Topping type;
    private  MeatType meatType;
    private double price;
    private  boolean isPremium;

    public ToppingMain( Topping type, double price) {
        this.type = type ;
        this.price = price;
    }
    public Topping getType() {
        return type;
    }

    public void setType(Topping type) {
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
