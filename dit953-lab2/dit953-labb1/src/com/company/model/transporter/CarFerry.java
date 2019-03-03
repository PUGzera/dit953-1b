package com.company.model.transporter;

import com.company.model.car.Car;
import com.company.model.vehicle.Vehicle;

import java.awt.*;

public class CarFerry extends Vehicle {

    private Flatbed<Car> flatbed;

    public CarFerry(double enginePower, Color color, String modelName, double x, double y, double direction, int capacity) {
        super(0, enginePower, color, modelName, x , y, direction);
        flatbed = new Flatbed<>(capacity, x, y, direction, 0);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    public void load(Car transportable) {
        flatbed.addLoad(transportable, getCurrentSpeed());
    }

    public Car unload() {
        return flatbed.getFIFO(getCurrentSpeed());
    }

    public Flatbed<Car> getFlatbed() {
        return flatbed;
    }
}
