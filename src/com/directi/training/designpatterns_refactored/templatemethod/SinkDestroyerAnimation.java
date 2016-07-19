package com.directi.training.designpatterns_refactored.templatemethod;

public class SinkDestroyerAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Destroyer is sinking.");
    }
}