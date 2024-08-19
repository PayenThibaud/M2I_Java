package org.example.exo_observateur.exo1;


public class Supplier implements Observer {
    @Override
    public void update(Product product) {
        System.out.println("Suplier : le stock s'actualise avec le stock " + product.getStocklevel());
    }
}
