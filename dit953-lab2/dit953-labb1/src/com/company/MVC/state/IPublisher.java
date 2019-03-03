package com.company.MVC.state;

import com.company.MVC.subscriber.ISubscriber;

import java.util.List;

public interface IPublisher<T> {

    void subscribe(ISubscriber subscriber);

    void unsubscribe(ISubscriber subscriber);

    void notifySubscribers();

    List<T> getAll();

    void save(T item);


}
