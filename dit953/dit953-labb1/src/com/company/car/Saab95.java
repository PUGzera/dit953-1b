package com.company.car;

import com.company.Vector;
import com.company.car.Car;

import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95() {
        super(2, 125, Color.RED, "Saab95", 1, 1, 0);
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

    @Override
    public void move() {
        getVector().setCurrentVector(Vector.multiplicationWithScalar(getVector().getCurrentVector(), 1 + getCurrentSpeed() * speedFactor()));

    }

    /**
     * Rotates the car PI/6 radians around the Z-axis
     */
    @Override
    public void turnRight() {
        getVector().setCurrentVector(Vector.matrixMul(Vector.getRotationMatrix(Math.PI/6), getVector().getCurrentVector()));
    }

    /**
     * Rotates the car -PI/6 radians around the Z-axis
     */
    @Override
    public void turnLeft() {
        getVector().setCurrentVector(Vector.matrixMul(Vector.getRotationMatrix(-(Math.PI/6)), getVector().getCurrentVector()));
    }
}