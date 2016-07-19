package com.directi.training.designpatterns_refactored.templatemethod;

public class SinkFrigateAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Frigate is sinking.");
    }
}