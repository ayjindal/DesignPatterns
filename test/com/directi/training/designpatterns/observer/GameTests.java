package com.directi.training.designpatterns.observer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameTests
{
    GameTestClient _gameTestClient;

    @Before
    public void setup()
    {
        _gameTestClient = new GameTestClient();
        _gameTestClient.setup();
    }

    @Test
    public void testOnGameTick_AllPersonsOutdoorsShouldBeNotifiedOfSunrise()
    {
        _gameTestClient.everyoneGoesOut();
        _gameTestClient.tickOnce();
        assertTrue("Everyone should be feeling warm after sunrise.",
            _gameTestClient.outdoorsCharactersFeelWarm());
    }

    @Test
    public void testOnTwoGameTicks_AllPersonsOutdoorsShouldBeNotifiedOfSunset()
    {
        _gameTestClient.everyoneGoesOut();
        _gameTestClient.tickTwice();
        assertTrue("No-one should be feeling warm after sunset.", _gameTestClient.allFeelCold());
    }
}