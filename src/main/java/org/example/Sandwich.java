package org.example;

import java.util.List;


public class Sandwich {
    private  SandwichSize size;
    private  BreadType bread;
    private  String sideItem;
    private List<Topping> toppings;

    public Sandwich(SandwichSize size, BreadType bread, String sideItem, List<Topping> toppings) {
        this.size = size;
        this.bread = bread;
        this.sideItem = sideItem;
        this.toppings = toppings;
    }

    public Sandwich() {

    }

    public SandwichSize getSize() {
        return size;
    }

    public void setSize(SandwichSize size) {
        this.size = size;
    }

    public BreadType getBreadType() {
        return bread;
    }

    public void setBreadType(BreadType bread) {
        this.bread = bread;
    }

    public String getSideItem() {
        return sideItem;
    }

    public void setSideItem(String sideItem) {
        this.sideItem = sideItem;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
   // public double calculatePrice(){

    //   }

    @Override
    public String toString() {
        return "Sandwich{" +
                "size='" + size.toString() + '\'' +
                ", bread='" + bread.toString() + '\'' +
                ", sideItem='" + sideItem + '\'' +
                ", toppings=" + toppings +
                '}';
    }


}
