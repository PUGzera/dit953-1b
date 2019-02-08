package com.company.car;

import com.company.Vector;
import com.company.car.Car;

import java.awt.*;

public class Volvo240 extends Car {

    /**
     * used for calculating the {@link #speedFactor()}
     */
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, 100, Color.BLACK, "Volvo240", 1, 1, 0);
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
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
