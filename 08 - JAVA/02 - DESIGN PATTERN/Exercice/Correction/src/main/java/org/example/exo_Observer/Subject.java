package org.example.exo_Observer;

public interface Subject {
    void registerObserver (Observer observer);
    void removeObserver (Observer observer);
    void notifyObservers ();
}
