package com.company.transporter;

import com.company.car.Car;
import com.company.Vector;
import com.company.vehicle.Vehicle;

import java.awt.*;

@Deprecated
public abstract class Transporter<T extends Car> extends Vehicle implements ITransporter<T> {

    private Load<T> load;
    private boolean isRampDown;

    /**
     * @param nrDoors     Number of doors on the car ({@literal >}= 0)
     * @param enginePower Amount of HorsePower ({@literal >}= 0)
     * @param color       Color of the car
     * @param modelName   Car model
     * @param x           X position of the {@link #vector}
     * @param y           Y position of the {@link #vector}
     * @param z           Z position of the {@link #vector}
     */
    public Transporter(int nrDoors, double enginePower, Color color, String modelName, int x, int y, int z
                        , int capacity) {
        super(nrDoors, enginePower, color, modelName, x, y, z);
        load = new Load<>(capacity);
    }

    /**
     * Scalar multiplies the {@link #vector} with the ({@link #currentSpeed} * {@link #speedFactor()})
     */
    @Override
    public void move() {
        if(!isRampDown && load.getAngle() == 0 && load.getY() == 0) {
            load.getLoad().forEach(c -> c.setPosition(getVector()));
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

    public Load<T> getLoad() {
        return load;
    }

    public void setLoad(Load<T> load) {
        this.load = load;
    }

    public boolean isRampDown() {
        return isRampDown;
    }

    public void setRampDown(boolean rampDown) {
        isRampDown = rampDown;
    }

    public void raiseLoad(){
        if(getCurrentSpeed() == 0) load.setY(load.getY() + 1);
    }

    public void lowerLoad(){
        if(load.getY() - 1 > 0) load.setY(load.getY() - 1);
    }

    public void rotateLoad(){
        if(getCurrentSpeed() == 0) load.setAngle(load.getAngle() + 1);
    }
}
