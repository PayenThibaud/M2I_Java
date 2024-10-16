package org.example.demo_adapter;

public class TemperatureAdapter implements TemperatureSensor{

    private Temperature temperature;

    public TemperatureAdapter() {
        temperature = new Temperature();
    }

    @Override
    public double getTemperature() {
        return (this.temperature.getTemperature() - 32)*0.5/9.0;
    }
}
