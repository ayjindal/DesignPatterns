package com.directi.training.designpatterns_refactored.templatemethod;

public abstract class Ship
{
    private final Screen _screen;
    private final Game _game;
    protected float _health = 100;

    public Ship(Screen screen, Game game)
    {
        _screen = screen;
        _game = game;
    }

    public final void onHit(int impact)
    {
        updateHealthWithImpact(impact);

        Animation animation;
        if (isDead()) {
            animation = getSinkAnimation();
            _game.notifyShipLost(this);
        } else {
            animation = getExplodeAnimation();
        }
        animation.render(_screen);
    }

    public abstract Animation getExplodeAnimation();

    public abstract Animation getSinkAnimation();

    public abstract boolean isDead();

    public abstract void updateHealthWithImpact(int impact);
}