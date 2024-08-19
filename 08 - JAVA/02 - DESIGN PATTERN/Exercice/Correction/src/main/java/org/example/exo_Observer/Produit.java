package org.example.exo_Observer;

import java.util.ArrayList;
import java.util.List;

public class Produit implements Subject{
    private int stockLevel;
    private String name;
    private List<Observer> observers;

    public Produit(int stockLevel, String name) {
        this.stockLevel = stockLevel;
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void decreaseStock (){
        stockLevel --;
        notifyObservers();
    }

    public void increaseStock (){
        stockLevel++;
        notifyObservers();
    }

    public void setStockLevel (int stockLevel){
        this.stockLevel = stockLevel;
        notifyObservers();
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
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
//        observers.forEach(o -> o.update(stockLevel));
        observers.forEach(o -> o.update(this));
    }
}
