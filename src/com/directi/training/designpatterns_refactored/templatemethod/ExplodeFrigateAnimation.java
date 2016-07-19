package com.directi.training.designpatterns_refactored.templatemethod;

public class ExplodeFrigateAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Frigate is exploding.");
    }
}