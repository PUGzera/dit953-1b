package com.company.movable;

import com.company.car.Car;
import com.company.core.IPositionable;

/** Core car methods (change speed and direction)
 *  Used to implement core car methods for specific models
 * @author pugzera
 * @version 1.0
 */
public interface IMovable extends IPositionable {

    /**
     * See implementation {@link Car#move() }
     */
    void move();

    /**
     * See implementation {@link Car#turnRight() }
     */
    void turnRight();

    /**
     * See implementation {@link Car#turnLeft() }
     */
    void turnLeft();

    double getCurrentSpeed();

    void setCurrentSpeed(double amount);

}
