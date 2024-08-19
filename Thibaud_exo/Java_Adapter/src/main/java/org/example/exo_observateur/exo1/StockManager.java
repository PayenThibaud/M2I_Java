package org.example.exo_observateur.exo1;

public class StockManager implements Observer{
    @Override
    public void update(Product product) {
        System.out.println("StockManager : le stock s'actualiser avec le stock " + product.getStocklevel() );
    }
}
