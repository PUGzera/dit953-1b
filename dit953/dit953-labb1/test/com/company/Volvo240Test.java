package com.company;

import com.company.car.Volvo240;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Volvo240Test {
    Volvo240 volvo;

    @Before
    public void createCar() {
        volvo = new Volvo240();
    }

    // ------------
    // Speed factor
    // ------------
    @Test
    public void defaultSpeedFactor() {
        double actual = volvo.speedFactor();
        double expected = 1.25;
        Assert.assertEquals(actual, expected, 0.02);
    }
}
