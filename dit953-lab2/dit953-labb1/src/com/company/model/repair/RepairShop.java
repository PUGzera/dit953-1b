package com.company.model.repair;

import com.company.model.car.Car;
import com.company.model.core.Storage;

public class RepairShop {

    Storage<Car> cars;

    public RepairShop(int capacity, double x, double y, double direction) {
        cars = new Storage<>(capacity, x, y , direction);
    }

    public Car removeCar() {
        return cars.getFILO();
    }

    public void addCar(Car car) {
        cars.addLoad(car);
    }
}
