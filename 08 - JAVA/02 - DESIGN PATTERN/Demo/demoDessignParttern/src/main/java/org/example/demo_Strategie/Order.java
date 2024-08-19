package org.example.demo_Strategie;

public class Order {
    private double amount;

    public Order(double amount) {
        this.amount = amount;
    }

    public void pay(PaymentStrategy paymentStrategy){
        paymentStrategy.pay(amount);
    }
}
