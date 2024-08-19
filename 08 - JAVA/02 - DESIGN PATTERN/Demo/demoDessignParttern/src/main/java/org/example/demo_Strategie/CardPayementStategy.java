package org.example.demo_Strategie;

public class CardPayementStategy implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        System.out.println("Payement with a card : "+amount);
        return true;
    }
}
