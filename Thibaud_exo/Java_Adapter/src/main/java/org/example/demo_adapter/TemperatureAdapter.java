package org.example.demo_adapter;

public class TemperatureAdapter implements TemperatureSensor{

    private Temperature temperature;

    public TemperatureAdapter(Temperature temperature) {
        temperature = new Temperature();
    }

    @Override
    public double getTemperature() {
        return (this.temperature.getTemperature());
    }
}
