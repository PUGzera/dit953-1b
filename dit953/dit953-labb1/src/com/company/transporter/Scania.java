package com.company.transporter;

import com.company.car.Car;
import com.company.Vector;
import com.company.vehicle.Vehicle;

import java.awt.*;

public class Scania extends Vehicle implements ITransporter<Car> {

    private Load<Car> loadedCars;

    /**
     * @param nrDoors     Number of doors on the car ({@literal >}= 0)
     * @param enginePower Amount of HorsePower ({@literal >}= 0)
     * @param color       Color of the car
     * @param modelName   Car model
     * @param x           X position of the {@link #vector}
     * @param y           Y position of the {@link #vector}
     * @param z           Z position of the {@link #vector}
     */
    public Scania(int nrDoors, double enginePower, Color color, String modelName, int x, int y, int z
                  , int capacity) {
        super(nrDoors, enginePower, color, modelName, x, y, z);
        loadedCars = new Load<>(capacity);
    }

    @Override
    public double speedFactor(){
        return 0;
    }

    @Override
    public Car takeOutObject() {
        return loadedCars.getLoad().pop();
    }

    @Override
    public void addObject(Car object) {
        loadedCars.getLoad().push(object);
    }

    @Override
    public void move() {
        if(loadedCars.getAngle() == 0 && loadedCars.getY() == 0) {
            loadedCars.getLoad().forEach(c -> c.setPosition(getVector()));
            getVector().setCurrentVector(Vector.multiplicationWithScalar(getVector().getCurrentVector(), 1 + getCurrentSpeed() * speedFactor()));
        }
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
