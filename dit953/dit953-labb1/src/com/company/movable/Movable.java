package com.company.movable;

import com.company.Vector;
import com.company.movable.IMovable;

@Deprecated
public abstract class Movable implements IMovable {

    private Vector vector;

    private double currentSpeed;

    public double getCurrentSpeed() {
        return currentSpeed;
    }
}
