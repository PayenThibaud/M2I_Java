package org.example;

import org.example.Demo_Observer.Tablette;
import org.example.Demo_Observer.Telephone;
import org.example.Demo_Observer.WeatherStation;
import org.example.demo_adapter.TemperaturSensor;
import org.example.demo_adapter.TemperatureAdapter;
import org.example.demo_adapter.TemperatureKelvinAdapter;

public class Main {
    public static void main(String[] args) {
//        TemperaturSensor temperaturSensor = new TemperatureAdapter();
//        TemperaturSensor tempaturKelvin = new TemperatureKelvinAdapter();
//        System.out.println(temperaturSensor.getTemperatur() + "°c");
//        System.out.printf(tempaturKelvin.getTemperatur()+" kelvin");

        WeatherStation weatherStation = new WeatherStation();
        weatherStation.notifyObservers();
        Tablette tablette = new Tablette();
        Telephone telephone = new Telephone();

        weatherStation.registerObserver(tablette);
        weatherStation.registerObserver(telephone);

        weatherStation.notifyObservers();

        weatherStation.removeObserver(tablette);
        weatherStation.notifyObservers();
    }
}