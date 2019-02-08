package com.company.car;

import com.company.movable.IMovable;
import com.company.transportable.ITransportable;
import com.company.vehicle.Vehicle;

import java.awt.*;

/**
 * abstract base class for all cars
 */

public abstract class Car extends Vehicle implements ITransportable {


    /**
     * @param nrDoors     Number of doors on the car ({@literal >}= 0)
     * @param enginePower Amount of HorsePower ({@literal >}= 0)
     * @param color       Color of the car
     * @param modelName   Car model
     * @param x           X position of the {@link #vector}
     * @param y           Y position of the {@link #vector}
     * @param z           Z position of the {@link #vector}
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, int x, int y, int z) {
        super(nrDoors, enginePower, color, modelName, x, y, z);
    }
}
