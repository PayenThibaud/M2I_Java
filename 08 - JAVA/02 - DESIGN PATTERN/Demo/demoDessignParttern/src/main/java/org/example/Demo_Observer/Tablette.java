package org.example.Demo_Observer;

public class Tablette implements Observer{

    @Override
    public void update(Weather weather) {
        System.out.println("la tablette s'actualise avec la temperature "+weather.getTemperature());
    }
}
