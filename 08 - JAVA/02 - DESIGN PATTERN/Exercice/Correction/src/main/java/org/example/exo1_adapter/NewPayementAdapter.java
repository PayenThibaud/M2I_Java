package org.example.exo1_adapter;

public class NewPayementAdapter implements OldPayementGateway{
    private NewPayementGateway newPayementGateway;

    public NewPayementAdapter() {
        newPayementGateway = new NewPayementGateway();
    }

    @Override
    public void makePayement(String accountNumber, double amount) {
        newPayementGateway.authenticate(accountNumber);
        newPayementGateway.sendPayement(amount);
    }
}
