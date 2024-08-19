package org.example.demo_adapter;

import java.util.Random;

public class Temperature {
    private Random rand = new Random();

    public double getTemperature() {
        return rand.nextDouble();
    }
}
