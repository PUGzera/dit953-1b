package com.company;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarTest {
    private TestCar testCar;

    @Before
    public void newCar() {
        testCar = new TestCar();
        testCar.gas(1);
    }

    // ----------
    // Move
    // ----------
    @Test
    public void moveOnce() {
        testCar.move();
        double actualX = testCar.getVector().getCurrentVector()[0][0];
        double actualY = testCar.getVector().getCurrentVector()[1][0];
        Assert.assertEquals(actualX, 2,0.02);
        Assert.assertEquals(actualY, 2,0.02);
    }

    // ----------
    // Turn Right
    // ----------
    @Test
    public void turnRight() {
        double[][] expected = Vector.matrixMul(
                Vector.getRotationMatrix(Math.PI/6),
                testCar.getVector().getCurrentVector()
        );
        testCar.turnRight();
        double[][] actual = testCar.getVector().getCurrentVector();
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }

    // ----------
    // Turn Left
    // -----------
    @Test
    public void turnLeft() {
        double[][] expected = Vector.matrixMul(
                Vector.getRotationMatrix(-(Math.PI/6)),
                testCar.getVector().getCurrentVector()
        );
        testCar.turnLeft();
        double[][] actual = testCar.getVector().getCurrentVector();
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }
    @Test
    public void turnMoveTurn() {
        double[][] leftOnce = Vector.matrixMul(
                Vector.getRotationMatrix(-(Math.PI/6)),
                testCar.getVector().getCurrentVector()
        );
        double[][] moveOnce = Vector.multiplicationWithScalar(
                leftOnce, 1+testCar.getCurrentSpeed()*testCar.speedFactor()
        );
        double[][] expected = Vector.matrixMul(
                Vector.getRotationMatrix(Math.PI/6),
                moveOnce
        );
        testCar.turnLeft();
        testCar.move();
        testCar.turnRight();
        double[][] actual = testCar.getVector().getCurrentVector();
        for(int i = 0; i < actual.length; i++) {
            Assert.assertArrayEquals(expected[i], actual[i], 0.002);
        }
    }

    // ---------------
    // Gas
    // ---------------
    @Test
    public void gas() {
        testCar.gas(0.5);
        Assert.assertEquals(1.5, testCar.getCurrentSpeed(),0.02);
    }
    @Test
    public void gasAmount2() {
        double tmp = testCar.getCurrentSpeed();
        testCar.gas(2);
        Assert.assertEquals(tmp,testCar.getCurrentSpeed(),0.02);
    }
    @Test
    public void gasAmountNegative2() {
        double tmp = testCar.getCurrentSpeed();
        testCar.gas(-2);
        Assert.assertEquals(tmp,testCar.getCurrentSpeed(),0.02);
    }

    // -----------
    // Brake
    // -----------
    @Test
    public void brake() {
        testCar.brake(1);
        Assert.assertEquals(0, testCar.getCurrentSpeed(), 0.02);
    }
    @Test
    public void brakeAmount2() {
        double tmp = testCar.getCurrentSpeed();
        testCar.brake(2);
        Assert.assertEquals(tmp,testCar.getCurrentSpeed(),0.02);
    }
    @Test
    public void brakeAmountNegative2() {
        double tmp = testCar.getCurrentSpeed();
        testCar.brake(2);
        Assert.assertEquals(tmp,testCar.getCurrentSpeed(),0.02);
    }

}
