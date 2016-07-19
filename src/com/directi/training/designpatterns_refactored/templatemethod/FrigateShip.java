package com.directi.training.designpatterns_refactored.templatemethod;

public class FrigateShip extends Ship
{
    private int _engineHealth = 5;
    private int _armor = 5;

    public FrigateShip(Screen screen, Game game)
    {
        super(screen, game);
    }

    @Override
    public Animation getExplodeAnimation()
    {
        return new ExplodeFrigateAnimation();
    }

    @Override
    public Animation getSinkAnimation()
    {
        return new SinkFrigateAnimation();
    }

    @Override
    public boolean isDead()
    {
        return _health <= 0 || _engineHealth <= 0;
    }

    @Override
    public void updateHealthWithImpact(int impact)
    {
        _health -= (_armor > 0 ? 1 : impact * 2.5);
        if (impact > 5 && _armor <= 0) {
            _engineHealth -= 1;
        }
        if (_armor > 0) {
            _armor -= 1;
        }
    }
}