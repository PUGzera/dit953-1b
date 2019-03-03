package com.company.model.movable;

/** Core car methods (change speed and direction)
 *  Used to implement core car methods for specific models
 * @author pugzera
 * @version 1.0
 */
public interface IMovable {

    void move();

    void turnRight();

    void turnLeft();

    double getCurrentSpeed();

    void setCurrentSpeed(double amount);

}
