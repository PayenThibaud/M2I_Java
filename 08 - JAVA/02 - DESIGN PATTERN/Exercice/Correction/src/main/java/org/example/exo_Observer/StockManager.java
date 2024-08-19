package org.example.exo_Observer;

public class StockManager implements Observer{
    @Override
    public void update(Produit produit) {
        System.out.println("StockManager : le stock du produit a ete modifié : "+produit.getName() + "a un stock de : "+produit.getStockLevel() );
    }
}
