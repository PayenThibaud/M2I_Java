package org.example.demo_adapter;

public class TemperatureAdapter implements TemperaturSensor{

    private FahrenheitSensor fahrenheitSensor;

    public TemperatureAdapter( ) {
        fahrenheitSensor = new FahrenheitSensor();
    }

    @Override
    public double getTemperatur() {
        return (this.fahrenheitSensor.getTemperature() - 32)*0.5/9.0;
    }
}
