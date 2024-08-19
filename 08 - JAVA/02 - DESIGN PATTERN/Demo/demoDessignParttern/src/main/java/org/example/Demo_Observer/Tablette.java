package org.example.Demo_Observer;

public class Tablette implements Observer{

    @Override
    public void update(Weather weather) {
        System.out.println("la ablette s'actualise avec la temperature "+weather.getTemperature());
    }
}
