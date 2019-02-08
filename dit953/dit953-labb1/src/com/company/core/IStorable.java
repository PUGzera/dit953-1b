package com.company.core;

public interface IStorable<T> {

    T takeOutObject();

    void addObject(T object);

}
