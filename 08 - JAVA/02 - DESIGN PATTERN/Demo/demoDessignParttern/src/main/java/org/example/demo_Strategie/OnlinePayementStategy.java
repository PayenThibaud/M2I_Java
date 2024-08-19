package org.example.demo_Strategie;

public class OnlinePayementStategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.printf("Online payement : "+amount);
        return true;
    }
}
