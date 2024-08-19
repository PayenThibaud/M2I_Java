package org.example;

import org.example.demo_adapter.TemperaturSensor;
import org.example.demo_adapter.TemperatureAdapter;
import org.example.demo_adapter.TemperatureKelvinAdapter;

public class Main {
    public static void main(String[] args) {
        TemperaturSensor temperaturSensor = new TemperatureAdapter();
        TemperaturSensor tempaturKelvin = new TemperatureKelvinAdapter();
        System.out.println(temperaturSensor.getTemperatur() + "°c");
        System.out.printf(tempaturKelvin.getTemperatur()+" kelvin");
    }
}