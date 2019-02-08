package com.company.vehicle;

import com.company.Vector;
import com.company.movable.IMovable;

import java.awt.*;

public abstract class Vehicle implements IMovable {

    private Vector vector;
    private double currentSpeed;
    private final int nrDoors;
    private final double enginePower;
    private final String modelName;
    private Color color;


    /**
     * @param nrDoors Number of doors on the car ({@literal >}= 0)
     * @param enginePower Amount of HorsePower ({@literal >}= 0)
     * @param color Color of the car
     * @param modelName Car model
     * @param x X position of the {@link #vector}
     * @param y Y position of the {@link #vector}
     * @param z Z position of the {@link #vector}
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, int x, int y, int z) {
        if(nrDoors >= 0 || enginePower >= 0) {
            this.nrDoors = nrDoors;
            this.enginePower = enginePower;
            this.color = color;
            this.modelName = modelName;
            this.currentSpeed = 0;
            vector = new Vector(x, y ,z);
        } else {
            throw new IllegalArgumentException("nrDoors and enginePower has to be >= 0");
        }
    }

    /**
     *
     * @return the number of doors on the car
     */
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     *
     * @return the model of the car as a {@link String}
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     * @return {@link #currentSpeed}
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public Color getColor() {
        return color;
    }

    public Vector getVector() {
        return vector;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract double speedFactor();

    /**
     * starts the engine by setting the cars speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * stops the engine by setting the cars speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     *
     * @param amount increments speed by the minimum of amount and {@link #enginePower}
     */

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    /**
     *
     * @param amount decrements speed by the maximum of amount and 0
     */
    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

    /**
     * increases the speed
     * @param amount only used if amount is in the range [0,1]
     */
    public void gas(double amount) {
        if(amount >= 0 && amount <= 1)
            incrementSpeed(amount);
    }

    /**
     * decreases the speed
     * @param amount only used if amount is in the range [0,1]
     */
    public void brake(double amount) {
        if(amount >= 0 && amount <= 1)
            decrementSpeed(amount);
    }

    @Override
    public Vector getPosition() {
        return vector;
    }

    @Override
    public void setPosition(Vector vector) {
        this.vector = vector;
    }

    @Override
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }
}
