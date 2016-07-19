package com.directi.training.designpatterns_refactored.templatemethod;

public class DestroyerShip extends Ship
{
    private float _reactorHealth = 10;

    public DestroyerShip(Screen screen, Game game)
    {
        super(screen, game);
    }

    @Override
    public Animation getExplodeAnimation()
    {
        return new ExplodeDestroyerAnimation();
    }

    @Override
    public Animation getSinkAnimation()
    {
        return new SinkDestroyerAnimation();
    }

    @Override
    public boolean isDead()
    {
        return _health <= 0 || _reactorHealth <= 0;
    }

    @Override
    public void updateHealthWithImpact(int impact)
    {
        _health -= impact * 1.2;
        if (impact > 15) {
            _reactorHealth -= 1;
        }
    }
}