package org.example.exo_adapter.exo1;

public class NewPaymentProcessor {
    public void authenticate(String apiKey){
        System.out.println("Authenticating...");
    };

    public void sendPayment(double amount) {
        System.out.println("Sending payment...");
    }
}
