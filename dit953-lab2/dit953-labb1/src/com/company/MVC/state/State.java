package com.company.MVC.state;

import com.company.MVC.subscriber.ISubscriber;
import com.company.model.vehicle.Vehicle;
import com.company.model.vehicle.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class State implements IPublisher<Vehicle> {

    private final List<Vehicle> vehicleList;

    private final List<ISubscriber> subscribers;

    private VehicleFactory vehicleFactory = new VehicleFactory();

    private Timer timer = new Timer(50, new TimerListener());

    private final static State state = new State();

    private State() {
        this.subscribers = new ArrayList<>();
        this.vehicleList = new ArrayList<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public List<Vehicle> getAll() {
        return Collections.unmodifiableList(vehicleList);
    }

    @Override
    public void save(Vehicle item) {
        vehicleList.add(item);
    }

    public void gas(double amount){
        vehicleList.forEach(v -> v.gas(amount));
    }

    public void brake(double amount){
        vehicleList.forEach(v -> v.brake(amount));
    }

    public void move(){
        vehicleList.forEach(Vehicle::move);
    }

    public void checkForCollision(){
        vehicleList.forEach(c -> {
            if (c.getPosition().getX() < 0 || c.getPosition().getX() > 800 || c.getPosition().getY() < 0 || c.getPosition().getY() + 60 > 800 - 240) {
                c.getPosition().changeDirection(Math.PI);
            }
        });
    }

    @Override
    public void notifySubscribers(){
        subscribers.forEach(ISubscriber::update);
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkForCollision();
            move();
            notifySubscribers();
        }
    }

    public Timer getTimer() {
        return timer;
    }

    public static State STATE() {
        return state;
    }

    public void generateVehicle(){
        if(vehicleList.size() < 10) {
            Vehicle vehicle = vehicleFactory.generateVehicle();
            save(vehicle);
        }
    }

    public void removeVehicle(){
        if(vehicleList.size() > 0) vehicleList.remove(0);
    }
}
