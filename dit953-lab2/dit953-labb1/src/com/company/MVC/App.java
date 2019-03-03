package com.company.MVC;

import com.company.MVC.subscriber.CarView;
import com.company.MVC.state.State;
import com.company.MVC.subscriber.NewView;
import com.company.model.car.Saab95;
import com.company.model.car.Volvo240;

import static com.company.MVC.state.State.STATE;


public class App {


    public static void main(String[] args) {
        STATE().save(new Volvo240(10, 10));
        STATE().save(new Saab95(100, 100));
        CarView carView = new CarView("CarSim 1.0", null);
        NewView newView = new NewView();
        carView.subscribe();
        newView.subscribe();
    }

}
