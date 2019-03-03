package com.company.model.core;

public class Position implements IPositionable {
    private double x;
    private double y;
    private double direction;

    public Position(double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getDirection() {
        return direction;
    }

    @Override
    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void setDirection(double direction) {
        this.direction = direction % 360;
    }

    @Override
    public void changeDirection(double direction) {
        setDirection(this.direction + direction);
    }

}
