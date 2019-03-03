package com.company.model.core;

//jsWQc
public interface IPositionable {
    double getX();
    double getY();
    double getDirection();

    void setPosition(double x, double y);

    /**
     *
     * @param direction direction in radians
     */
    void setDirection(double direction);

    /**
     *
     * @param direction changes direction by direction°
     */
    void changeDirection(double direction);
}
