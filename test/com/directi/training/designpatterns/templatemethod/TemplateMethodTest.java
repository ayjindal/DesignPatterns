package com.directi.training.designpatterns.templatemethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateMethodTest
{
    @Test
    public void testBasicStuffWorks()
    {
        Screen screen = new Screen();
        Game game = new Game(screen);

        Ship frigate = new Ship(screen, game, ShipType.Frigate);
        Ship destroyer = new Ship(screen, game, ShipType.Destroyer);

        frigate.onHit(50);
        destroyer.onHit(50);
        frigate.onHit(50);
        destroyer.onHit(50);

        String printedMsg = "Frigate is exploding.\nDestroyer is exploding.\nFrigate is exploding.\nDestroyer lost.\nDestroyer is sinking.\n";
        assertEquals(printedMsg, screen.getScreenMsg());
    }
}
