package com.company.model.transporter;

import com.company.model.car.Car;
import com.company.model.vehicle.Vehicle;

import java.awt.*;

public class CarTransport extends Vehicle {

    private Flatbed<Car> flatbed;

    public CarTransport(int nrDoors, double enginePower, Color color, String modelName, double x, double y, double direction, int capacity) {
        super(nrDoors, enginePower, color, modelName, x , y, direction);
        flatbed = new Flatbed<>(capacity, x, y, direction, 1);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if(flatbed.getAngle() == 0) {
            super.move();
            flatbed.setPosition(getPosition());
        }
    }

    public void load(Car transportable) {
            flatbed.addLoad(transportable, getCurrentSpeed());
    }

    public Car unload() {
            return flatbed.getFILO(getCurrentSpeed());
    }

    public void openRamp() {
        if(getCurrentSpeed() == 0) {
            flatbed.setAngle(1);
        }
    }

    public void closeRamp() {
        if(getCurrentSpeed() == 0) {
            flatbed.setAngle(0);
        }
    }

    public Flatbed<Car> getFlatbed() {
        return flatbed;
    }
}
