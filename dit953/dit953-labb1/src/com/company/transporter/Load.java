package com.company.transporter;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Load<T> {
    private Deque<T> load;
    private double y;
    private double angle;

    public Load(int capacity){
        y = 0;
        angle = 0;
        load = new LinkedBlockingDeque<>(capacity);
    }

    public Deque<T> getLoad() {
        return load;
    }

    public void setLoad(Deque<T> load) {
        this.load = load;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
