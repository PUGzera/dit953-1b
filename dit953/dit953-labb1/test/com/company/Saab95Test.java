package com.company;

import com.company.car.Saab95;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Saab95Test {
    Saab95 saab;

    @Before
    public void createCar() {
        saab = new Saab95();
    }

    // ------------
    // Speed factor
    // ------------
    @Test
    public void defaultSpeedFactor() {
        double actual = saab.speedFactor();
        double expected = 125 * 0.01;
        Assert.assertEquals(actual, expected, 0.02);
    }

    @Test
    public void turboSpeedFactor() {
        saab.setTurboOn();
        double actual = saab.speedFactor();
        double expected = 125 * 0.01 * 1.3;
        Assert.assertEquals(actual, expected, 0.02);

    }
}
