package com.company;

import com.company.car.Car;

import java.awt.*;

public class TestCar extends Car {
    protected TestCar() {
        super(4,100, Color.BLACK,"test car", 1, 1 ,0);
    }
    @Override
    double speedFactor() {
        return 1;
    }
}
