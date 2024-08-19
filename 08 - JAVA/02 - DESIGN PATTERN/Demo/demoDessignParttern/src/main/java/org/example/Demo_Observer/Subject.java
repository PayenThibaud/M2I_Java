package org.example.Demo_Observer;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    public void notifyObservers();
}
