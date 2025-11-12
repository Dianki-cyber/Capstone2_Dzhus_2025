package org.example;

import java.util.ArrayList;
import java.util.List;

    public class Order {
    private int orderNumber;
    private List<Sandwich> sandwiches;
    private double totalPrice;

    public Order(int orderNumber, double totalPrice, List<Sandwich> sandwiches) {
        this.orderNumber = orderNumber;
        this.totalPrice = 0.00;
        this.sandwiches = new ArrayList<>();
    }

        public int getOrderNumber() {
            return orderNumber;
        }

        public List<Sandwich> getSandwiches() {
            return sandwiches;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

    }
