package com.directi.training.designpatterns_refactored.observer;

import java.util.ArrayList;
import java.util.List;

public class Sun
{
    private boolean _up;
    private List<ISunSubscriber> _subscribers = new ArrayList<>(4);

    public boolean isUp()
    {
        return _up;
    }

    public void set()
    {
        _up = false;
        for (ISunSubscriber subscriber : _subscribers) {
            subscriber.notifySunSet();
        }
    }

    public void rise()
    {
        _up = true;
        for (ISunSubscriber subscriber : _subscribers) {
            subscriber.notifySunRose();
        }
    }

    public void subscribe(ISunSubscriber subscriber)
    {
        _subscribers.add(subscriber);
    }

    public void unsubscribe(ISunSubscriber subscriber)
    {
        _subscribers.remove(subscriber);
    }
}
