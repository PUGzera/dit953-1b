package com.company.model.vehicle;

import com.company.model.core.Position;

import java.awt.*;

public abstract class VehicleBuilder implements IVehicleBuilder {
    private Position position;
    private double currentSpeed;
    private int nrDoors;
    private double enginePower;
    private String modelName;
    private Color color;

    @Override
    public IVehicleBuilder position(Position position) {
        this.position = position;
        return this;
    }

    @Override
    public IVehicleBuilder nrDoors(int nrDoors) {
        this.nrDoors = nrDoors;
        return this;
    }

    @Override
    public IVehicleBuilder enginePower(double enginePower) {
        this.enginePower = enginePower;
        return this;
    }

    @Override
    public IVehicleBuilder modelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    @Override
    public IVehicleBuilder color(Color color) {
        this.color = color;
        return this;
    }
}
