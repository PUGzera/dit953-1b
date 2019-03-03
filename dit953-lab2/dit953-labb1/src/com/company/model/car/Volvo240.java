package com.company.model.car;


import java.awt.*;

public class Volvo240 extends Car {

    /**
     * used for calculating the {@link #speedFactor()}
     */
    private final static double trimFactor = 1.25;

    public Volvo240(double x, double y) {
        super(4, 100, Color.BLACK, "Volvo240", x, y, Math.PI/2);
    }


    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
