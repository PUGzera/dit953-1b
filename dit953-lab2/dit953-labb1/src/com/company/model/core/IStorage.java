package com.company.model.core;

import java.util.Deque;

public interface IStorage<T> {

    void addLoad(T object);

    T getFIFO();

    T getFILO();

    Deque<T> getLoad();

    void setLoad(Deque<T> object);

    int getCapacity();

    void setCapacity(int capacity);
}
