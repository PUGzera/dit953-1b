package com.company.model.vehicle;

import com.company.model.car.Saab95;
import com.company.model.car.Volvo240;
import com.company.model.transporter.Scania;

import java.util.Random;

public class VehicleFactory {

    Random r = new Random();

    public Vehicle generateVehicle(){
        int seed = r.nextInt(2) + 1;
        switch (seed){
            case 1:
                return new Volvo240(10, 0);
            case 2:
                return new Saab95(120, 0);
            case 3:
                return new Scania(230, 0);
            default:
                return new Volvo240(10 ,0);
        }
    }
}
