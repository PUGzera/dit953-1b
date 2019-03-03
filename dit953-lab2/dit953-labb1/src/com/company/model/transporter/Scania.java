package com.company.model.transporter;

import com.company.model.core.ITransportable;
import com.company.model.vehicle.Vehicle;

import java.awt.*;

public class Scania extends Vehicle {

    private Flatbed<ITransportable> flatbed;

    /**
     * @param capacity capacity of the truck's flatbed
     * @param x
     * @param y
     * @param direction
     */
    public Scania(double x, double y, double direction, int capacity) {
        super(2, 320, Color.RED, "Scania", x, y, direction);
        flatbed = new Flatbed<>(capacity, x, y , direction, 70);
    }

    public Scania(double x, double y) {
        this(x,y,Math.PI/2,10);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

    @Override
    public void move() {
        if(flatbed.getAngle() == 0) {
            super.move();
            flatbed.setPosition(getPosition());
        }
    }

    public void increaseAngle(double amount) {
        if(getCurrentSpeed() == 0 && flatbed.getAngle() + amount <= 70 && amount > 0) {
            flatbed.setAngle(flatbed.getAngle() + amount);
        }
    }

    public void decreaseAngle(double amount) {
        if(getCurrentSpeed() == 0 && flatbed.getAngle() - amount > 0 && amount > 0) {
            flatbed.setAngle(flatbed.getAngle() - amount);
        }
    }

    public void load(ITransportable transportable) {
        flatbed.addLoad(transportable, getCurrentSpeed());
    }

    public ITransportable unload() {
        return flatbed.getFILO();
    }

    public Flatbed<ITransportable> getFlatbed() {
        return flatbed;
    }
}
