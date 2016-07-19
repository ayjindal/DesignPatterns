package com.directi.training.designpatterns.templatemethod;

public class ExplodeDestroyerAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Destroyer is exploding.");
    }
}
