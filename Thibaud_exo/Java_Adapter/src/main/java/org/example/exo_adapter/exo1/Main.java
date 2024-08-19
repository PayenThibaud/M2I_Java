package org.example.exo_adapter.exo1;

public class Main {
    public static void main(String[] args) {
        OldpaymentGateway paymentGateway = new PaymentAdapter("11.11.11.11");

        paymentGateway.makePayment("123456789", 250.00);
    }
}
