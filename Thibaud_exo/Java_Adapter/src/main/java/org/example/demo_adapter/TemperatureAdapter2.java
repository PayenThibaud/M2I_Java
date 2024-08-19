package org.example.demo_adapter;

public class TemperatureAdapter2 implements TemperatureSensor{

    private Temperature temperature;

    public TemperatureAdapter2() {
        temperature = new Temperature();
    }

    @Override
    public double getTemperature() {
        return (this.temperature.getTemperature());
    }
}
