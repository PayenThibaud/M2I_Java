package org.example.exo_adapter.exo1;

public class PaymentAdapter implements OldpaymentGateway{

    private NewPaymentProcessor processor;
    private String apiKey;

    public PaymentAdapter(String apiKey) {
        processor = new NewPaymentProcessor();
        this.apiKey = apiKey;
        processor.authenticate(apiKey);
    }

    @Override
    public void makePayment(String accountNumber, double amount) {
        System.out.println("Payement du compte : " + accountNumber + " avec un montant de : " + amount);
        processor.sendPayment(amount);
    }
}
