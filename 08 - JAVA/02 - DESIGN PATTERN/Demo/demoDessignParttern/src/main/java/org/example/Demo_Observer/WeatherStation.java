package org.example.Demo_Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeatherStation  implements Subject{

    private List<Observer> observers;
    private Random random;

    public WeatherStation() {
        observers = new ArrayList<>();
        random = new Random();
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
        double temp  = random.nextDouble(-50,50);
        for(Observer observer : observers){
            observer.update(new Weather(temp));
        }
    }
}
