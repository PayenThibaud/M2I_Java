package org.example;

import org.example.Demo_Observer.Tablette;
import org.example.Demo_Observer.Telephone;
import org.example.Demo_Observer.WeatherStation;
import org.example.demo_abstractFactory.abstracts.Button;
import org.example.demo_abstractFactory.mac.MacFactory;
import org.example.demo_abstractFactory.windows.WinFactory;
import org.example.demo_adapter.TemperaturSensor;
import org.example.demo_adapter.TemperatureAdapter;
import org.example.demo_adapter.TemperatureKelvinAdapter;
import org.example.demo_builder.Voiture;

public class Main {
    public static void main(String[] args) {
//        TemperaturSensor temperaturSensor = new TemperatureAdapter();
//        TemperaturSensor tempaturKelvin = new TemperatureKelvinAdapter();
//        System.out.println(temperaturSensor.getTemperatur() + "°c");
//        System.out.printf(tempaturKelvin.getTemperatur()+" kelvin");

//        WeatherStation weatherStation = new WeatherStation();
//        weatherStation.notifyObservers();
//        Tablette tablette = new Tablette();
//        Telephone telephone = new Telephone();
//
//        weatherStation.registerObserver(tablette);
//        weatherStation.registerObserver(telephone);
//
//        weatherStation.notifyObservers();
//
//        weatherStation.removeObserver(tablette);
//        weatherStation.notifyObservers();


//        MacFactory macFactory = new MacFactory();
//        WinFactory winFactory = new WinFactory();
//        Button button = macFactory.createButton();
//        button = winFactory.createButton();

        Voiture voiture = new Voiture.VoitureBuilder().couleur("rouge").nbrPorte(5).reservoire(200).nbrRoue(4).build();
        Voiture voiture2 = new Voiture.VoitureBuilder().marque("autoMarque").couleur("vert").reservoire(102).build();

        System.out.println(voiture);
        System.out.println(voiture2);
    }
}