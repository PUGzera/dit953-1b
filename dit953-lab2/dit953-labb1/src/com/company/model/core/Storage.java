package com.company.model.core;

import java.util.ArrayDeque;
import java.util.Deque;

public class Storage<T extends IStorable> implements IStorage<T> {
    private Deque<T> load;
    private Position position;
    private int capacity;

    public Storage(int capacity, double x, double y, double direction) {
        position = new Position(x, y, direction);
        this.capacity = capacity;
        load = new ArrayDeque<>(capacity);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
        load.forEach(c -> c.setPosition(position.getX(), position.getY()));
    }

    @Override
    public void addLoad(T object) {
        if(getLoad().size() + 1 > getCapacity())
            throw new RuntimeException("Storage already at capacity");
        load.add(object);
    }

    @Override
    public T getFIFO() {
        if(getLoad().size() - 1 < 0)
            throw new RuntimeException("Storage already empty");
        return load.pop();
    }

    @Override
    public T getFILO() {
        if(getLoad().size() - 1 < 0)
            throw new RuntimeException("Storage already empty");
        T a = load.getLast();
        load.removeLast();
        return a;
    }

    @Override
    public Deque<T> getLoad() {
        return load;
    }

    @Override
    public void setLoad(Deque<T> object) {
        load = object;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
