package com.directi.training.designpatterns.observer;

public class Game
{
    private Sun _sun;

    public Game(Sun sun)
    {
        _sun = sun;
    }

    public void tick()
    {
        if (_sun.isUp()) {
            _sun.set();
        } else {
            _sun.rise();
        }
    }
}