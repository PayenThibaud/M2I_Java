package org.example.demo_adapter;

import java.util.Random;

public class FahrenheitSensor {
    private Random rand = new Random();

    public  double getTemperature() {
        double temp = rand.nextDouble(-100,100);
        System.out.println(temp +" °f");
        return temp;
    }
}
