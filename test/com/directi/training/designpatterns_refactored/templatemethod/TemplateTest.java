package com.directi.training.designpatterns_refactored.templatemethod;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemplateTest
{
    @Test
    public void testBasicStuffWorks()
    {
        Screen screen = new Screen();
        Game game = new Game(screen);

        FrigateShip frigateShip = new FrigateShip(screen, game);
        DestroyerShip destroyerShip = new DestroyerShip(screen, game);

        frigateShip.onHit(50);
        destroyerShip.onHit(50);
        frigateShip.onHit(50);
        destroyerShip.onHit(50);
        String printedData = "Frigate is exploding.\n" +
                             "Destroyer is exploding.\n" +
                             "Frigate is exploding.\n" +
                             "DestroyerShip lost.\n" +
                             "Destroyer is sinking.\n";
        assertEquals("Screen should contain expected data", printedData, screen.getScreenMsg());
    }
}
