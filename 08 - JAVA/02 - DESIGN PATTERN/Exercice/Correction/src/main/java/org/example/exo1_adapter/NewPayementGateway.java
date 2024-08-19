package org.example.exo1_adapter;

public class NewPayementGateway {
    public void authenticate(String apiKey) {
        System.out.println("Authentiquate with key : "+apiKey);
    }

    public void sendPayement (double amount){
        System.out.println("payement new systeme "+amount+"€");
    }
}
