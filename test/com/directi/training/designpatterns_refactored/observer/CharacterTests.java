package com.directi.training.designpatterns_refactored.observer;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CharacterTests
{
    @Test
    public void testSanity()
    {
        CharacterTestClient client = new CharacterTestClient();
        assertTrue(client.testOutdoors());
        assertTrue(client.testSunRose());
        assertTrue(client.testSunSet());
        assertTrue(client.testIndoors());
    }
}