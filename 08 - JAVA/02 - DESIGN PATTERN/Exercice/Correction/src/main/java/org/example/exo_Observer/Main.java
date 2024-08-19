package org.example.exo_Observer;

public class Main {
    public static void main(String[] args) {
        Produit lait = new Produit(25,"Lait");

        lait.increaseStock();

        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();

        lait.registerObserver(stockManager);
        lait.registerObserver(supplier);

        lait.increaseStock();
        lait.decreaseStock();
        lait.setStockLevel(12);
    }
}
