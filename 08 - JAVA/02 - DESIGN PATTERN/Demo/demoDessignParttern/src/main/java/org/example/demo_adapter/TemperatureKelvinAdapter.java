package org.example.demo_adapter;

public class TemperatureKelvinAdapter implements TemperaturSensor{
    private FahrenheitSensor fahrenheitSensor;

    public TemperatureKelvinAdapter( ) {
        fahrenheitSensor = new FahrenheitSensor();
    }

    @Override
    public double getTemperatur() {
        return ((this.fahrenheitSensor.getTemperature() - 32)*0.5/9.0)+273.15;
    }
}
