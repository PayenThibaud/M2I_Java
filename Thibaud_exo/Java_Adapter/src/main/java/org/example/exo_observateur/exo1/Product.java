package org.example.exo_observateur.exo1;

import java.util.ArrayList;
import java.util.List;

public class Product implements Subject {

    private List<Observer> observers;
    private int stocklevel;

    public Product(int stocklevel) {
        this.stocklevel = stocklevel;
        observers = new ArrayList<Observer>();
    }

    public int getStocklevel() {
        return stocklevel;
    }
    public void setStocklevel(int stocklevel) {
        this.stocklevel = stocklevel;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
    observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(new Product(stocklevel));
        }

    }
}
