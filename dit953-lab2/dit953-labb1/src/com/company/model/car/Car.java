package com.company.model.car;

import com.company.model.vehicle.Vehicle;

import java.awt.*;

/**
 * abstract base class for all cars
 */

public abstract class Car extends Vehicle {


    /**
     * See {@link com.company.model.vehicle.Vehicle#Vehicle(int, double, Color, String, double, double, double)}
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName, double x, double y, double direction) {
        super(nrDoors, enginePower, color, modelName, x, y, direction);
    }
}
