package com.company.model.transporter;

import com.company.model.core.ITransportable;
import com.company.model.core.Storage;

public class Flatbed<T extends ITransportable> extends Storage<T> {
    private double angle;
    private double stoppedAngle;

    public Flatbed(int capacity, double x, double y, double direction, double stoppedAngle) {
        super(capacity, x, y, direction);
        this.angle = 0;
        this.stoppedAngle = stoppedAngle;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void addLoad(T object, double speed) {
        if(angle != stoppedAngle)
            throw new RuntimeException("wrong angle");
        else if(speed != 0)
            throw new RuntimeException("speed not 0");
        else
            addLoad(object);
    }



    public T getFIFO(double speed) {
        if(angle != stoppedAngle)
            throw new RuntimeException("wrong angle");
        else if(speed != 0)
            throw new RuntimeException("speed not 0");
        else
            return getFIFO();
    }

    public T getFILO(double speed) {
        if(angle != stoppedAngle)
            throw new RuntimeException("wrong angle");
        else if(speed != 0)
            throw new RuntimeException("speed not 0");
        else
            return getFILO();
    }
}
