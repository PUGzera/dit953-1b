package com.company.model.car;


import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(double x, double y) {
        super(2, 125, Color.RED, "Saab95", x, y, Math.PI/2);
    }

    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    @Override
    public double speedFactor() {
        double baseSpeedFactor = getEnginePower() * 0.01;
        return turboOn ? baseSpeedFactor * 1.3 : baseSpeedFactor;
    }
}