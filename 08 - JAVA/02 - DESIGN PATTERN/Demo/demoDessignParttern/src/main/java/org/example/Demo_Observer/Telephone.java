package org.example.Demo_Observer;

public class Telephone implements Observer{
    @Override
    public void update(Weather weather) {
        System.out.println("le telephone s'actualise avec la temperature "+weather.getTemperature());
    }
}
