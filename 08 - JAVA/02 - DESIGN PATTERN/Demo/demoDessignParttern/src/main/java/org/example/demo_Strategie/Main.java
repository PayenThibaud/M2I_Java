package org.example.demo_Strategie;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(1400);

        order.pay(new CardPayementStategy());
        order.pay(new OnlinePayementStategy());
    }
}
