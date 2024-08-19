package org.example.demo_adapter;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor temperatureSensor = new TemperatureAdapter();
        TemperatureSensor temperatureSensor2 = new TemperatureAdapter2();
        System.out.println(temperatureSensor.getTemperature() + " c");
        System.out.println(temperatureSensor2.getTemperature() + " Kelvin");
    }
}
