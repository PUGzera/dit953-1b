package com.company.model.vehicle;

import com.company.model.core.IStorable;
import com.company.model.core.ITransportable;
import com.company.model.core.Position;
import com.company.model.movable.IMovable;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Vehicle implements IMovable, IStorable, ITransportable {

    private Position position;
    private double currentSpeed;
    private final int nrDoors;
    private final double enginePower;
    private final String modelName;
    private Color color;

    /**
     *
     * @param nrDoors Number of doors on the car ({@literal >}= 0)
     * @param enginePower Amount of HorsePower ({@literal >}= 0)
     * @param color Color of the car
     * @param modelName Car model
     * @param x absolute X position of the vehicle
     * @param y absolute Y position of the vehicle
     * @param direction a value in radians, 0 being directly right, and PI being directly left
     */
    public Vehicle(int nrDoors, double enginePower, Color color, String modelName, double x, double y, double direction) {
        if(nrDoors >= 0 || enginePower >= 0) {
            this.nrDoors = nrDoors;
            this.enginePower = enginePower;
            this.color = color;
            this.modelName = modelName;
            this.currentSpeed = 0;
            position = new Position(x, y, direction);
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

    @Override
    public void move() {
        double direction = position.getDirection();
        double x = position.getX() + currentSpeed * Math.cos(direction);
        double y = position.getY() + currentSpeed * Math.sin(direction);
        position.setPosition(x, y);
    }

    /**
     * Decrements the direction by PI/6 radians
     */
    @Override
    public void turnRight() {
        position.changeDirection(-Math.PI/6);
    }

    /**
     * Increments the direction by PI/6 radians
     */
    @Override
    public void turnLeft() {
        position.changeDirection(Math.PI/6);
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
    public void setCurrentSpeed(double speed){
        currentSpeed = speed;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(double x, double y) {
        this.position.setPosition(x, y);
    }
}
