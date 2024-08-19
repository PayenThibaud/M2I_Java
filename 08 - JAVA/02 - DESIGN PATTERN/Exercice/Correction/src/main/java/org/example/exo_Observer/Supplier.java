package org.example.exo_Observer;

public class Supplier implements Observer{
    @Override
    public void update(Produit produit) {
        System.out.println("Supplier : le stock du produit a ete modifié : "+produit.getName() + "a un stock de : "+produit.getStockLevel());
    }
}
