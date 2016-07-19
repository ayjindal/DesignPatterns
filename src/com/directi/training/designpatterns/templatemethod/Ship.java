package com.directi.training.designpatterns.templatemethod;

public class Ship
{
    private final Screen _screen;
    private final Game _game;
    private final ShipType _shipType;
    private double _health = 100;
    private int _armor = 5;
    private int _engineHealth = 5;
    private int _reactorHealth = 5;

    public Ship(Screen screen, Game game, ShipType shipType)
    {
        _screen = screen;
        _game = game;
        _shipType = shipType;
    }

    public ShipType getShipType()
    {
        return _shipType;
    }

    public void onHit(int impact)
    {
        if (_shipType == ShipType.Frigate) {
            _health -= (_armor > 0 ? 1 : impact * 2.5);
            if (impact > 5 && _armor <= 0) {
                _engineHealth -= 1;
            }
            if (_armor > 0) {
                _armor -= 1;
            }

            Animation animation;
            if (_health <= 0 || _engineHealth <= 0) {
                animation = new SinkFrigateAnimation();
                _game.notifyShipLost(_shipType);
            } else {
                animation = new ExplodeFrigateAnimation();
            }
            animation.render(_screen);
        } else if (_shipType == ShipType.Destroyer) {
            _health -= impact * 1.2;
            if (impact > 15) {
                _reactorHealth -= 1;
            }

            Animation animation;
            if (_health <= 0 || _reactorHealth <= 0) {
                animation = new SinkDestroyerAnimation();
                _game.notifyShipLost(_shipType);
            } else {
                animation = new ExplodeDestroyerAnimation();
            }
            animation.render(_screen);
        }
    }
}
