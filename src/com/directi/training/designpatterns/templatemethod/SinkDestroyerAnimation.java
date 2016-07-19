package com.directi.training.designpatterns.templatemethod;

public class SinkDestroyerAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Destroyer is sinking.");
    }
}
