package com.directi.training.designpatterns.observer;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SunTests
{
    @Test
    public void testAtSunrise_CharactersIndoorsAreNotNotified()
    {
        SunTestClient sunTestClient = new SunTestClient();
        sunTestClient.aFewCharactersGoOutdoors();
        sunTestClient.sunRise();
        assertTrue("Only outdoors characters are notified on sunrise.",
            sunTestClient.outdoorsCharactersFeelWarm());

        sunTestClient = new SunTestClient();
        sunTestClient.aFewOtherCharactersGoOutdoors();
        sunTestClient.sunRise();
        assertTrue("Only outdoors characters are notified on sunrise.",
            sunTestClient.outdoorsCharactersFeelWarm());
    }

    @Test
    public void testAtSunset_OnlyCharactersOutsideAreNotified()
    {
        SunTestClient suntestClient = new SunTestClient();
        suntestClient.aFewCharactersGoOutdoors();
        suntestClient.sunRise();
        suntestClient.sunSet();
        assertTrue("Characters who were outdoors at sunset feel tired.",
            suntestClient.outdoorsCharactersFeelTired());
    }
}
