package org.example.exo_observateur.exo1;

public interface Subject {

    void registerObserver(Observer observer);
    void removeObserver(Observer observer);

    public void notifyObservers();
}