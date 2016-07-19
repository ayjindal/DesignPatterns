package com.directi.training.designpatterns.templatemethod;

public class Game
{
    private final Screen _screen;

    public Game(Screen screen)
    {
        _screen = screen;
    }

    public void notifyShipLost(ShipType shipType)
    {
        _screen.show(shipType.toString() + " lost.");
    }
}
