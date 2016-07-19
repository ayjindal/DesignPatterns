package com.directi.training.designpatterns_refactored.templatemethod;

public class Game
{
    private final Screen _screen;

    public Game(Screen screen)
    {
        _screen = screen;
    }

    public void notifyShipLost(Ship ship)
    {
        String[] nameParts = ship.getClass().getName().split("\\.");
        _screen.show(nameParts[nameParts.length - 1] + " lost.");
    }
}