package org.example;

import java.util.ArrayList;
import java.util.List;

    public class Order {
    private int orderNumber;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips ;


        public void setOrderNumber(int orderNumber) {
            this.orderNumber = orderNumber;
        }

        public void setSandwiches(List<Sandwich> sandwiches) {
            this.sandwiches = sandwiches;
        }

        public List<Drink> getDrinks() {
            return drinks;
        }

        public void setDrinks(List<Drink> drinks) {
            this.drinks = drinks;
        }

        public List<Chips> getChips() {
            return chips;
        }

        public void setChips(List<Chips> chips) {
            this.chips = chips;
        }

        public Order(int orderNumber, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.orderNumber = orderNumber;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;

    }

        public int getOrderNumber() {
            return orderNumber;
        }

        public List<Sandwich> getSandwiches() {
            return sandwiches;
        }

        public double getTotalPrice() {
            double price = 0.00;
            for(Sandwich sandwich : sandwiches ){
                price += sandwich.getPrice();
            }
            for (Drink drink :drinks){
                price += drink.getPrice();
            }
            for (Chips chip : chips){
                price += chip.getPrice();
            }
            return price;
        }

    }
