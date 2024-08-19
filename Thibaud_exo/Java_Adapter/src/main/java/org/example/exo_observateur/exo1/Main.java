package org.example.exo_observateur.exo1;

public class Main {
    public static void main(String[] args) {

        Product product = new Product(50);

        StockManager stockManager = new StockManager();
        Supplier supplier = new Supplier();

        product.registerObserver(stockManager);
        product.registerObserver(supplier);

        product.setStocklevel(100);
        product.setStocklevel(75);

        product.removeObserver(stockManager);

        product.setStocklevel(50);
    }
}
