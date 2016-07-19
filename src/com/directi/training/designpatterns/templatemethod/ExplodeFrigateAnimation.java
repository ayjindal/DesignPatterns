package com.directi.training.designpatterns.templatemethod;

public class ExplodeFrigateAnimation implements Animation
{
    @Override
    public void render(Screen screen)
    {
        screen.show("Frigate is exploding.");
    }
}
