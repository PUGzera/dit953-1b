package com.company.repair;

import com.company.core.IStorable;
import com.company.vehicle.Vehicle;

import java.util.List;

public class RepairShop implements IStorable<Vehicle> {

    List<Vehicle> vehicles;

    @Override
    public Vehicle takeOutObject() {
        return vehicles.get(0);
    }

    @Override
    public void addObject(Vehicle object) {
        vehicles.add(object);
    }
}
