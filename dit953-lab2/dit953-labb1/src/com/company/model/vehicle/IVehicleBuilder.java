package com.company.model.vehicle;

import com.company.model.core.Position;

import java.awt.*;

public interface IVehicleBuilder<T extends Vehicle> {

    IVehicleBuilder position(Position position);

    IVehicleBuilder nrDoors(int nrDoors);

    IVehicleBuilder enginePower(double enginePower);

    IVehicleBuilder modelName(String modelName);

    IVehicleBuilder color(Color color);

    T build();
}
