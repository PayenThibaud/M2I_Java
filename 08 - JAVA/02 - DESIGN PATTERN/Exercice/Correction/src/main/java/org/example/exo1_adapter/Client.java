package org.example.exo1_adapter;

public class Client {
    public static void main(String[] args) {
        OldPayementGateway payementGateway = new NewPayementAdapter();

        payementGateway.makePayement("1234 4561 1456",1000);
    }
}
