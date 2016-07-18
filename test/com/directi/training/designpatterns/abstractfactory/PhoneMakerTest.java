package com.directi.training.designpatterns.abstractfactory;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PhoneMakerTest
{
    @Test
    public void testAndroidPhoneIsMadeCorrectly()
    {
        Case phone = new PhoneMaker().buildPhone("Android");
        assertEquals(AndroidCase.class, phone.getClass());
        assertEquals(AndroidScreen.class, phone.getScreen().getClass());
        assertEquals(AndroidMotherBoard.class, phone.getMotherBoard().getClass());
        assertEquals(AndroidProcessor.class, phone.getProcessor().getClass());
        assertEquals(Battery.class, phone.getBattery().getClass());
    }

    @Test
    public void testIPhoneIsMadeCorrectly()
    {
        Case phone = new PhoneMaker().buildPhone("Iphone");
        assertEquals(IphoneCase.class, phone.getClass());
        assertEquals(IphoneScreen.class, phone.getScreen().getClass());
        assertEquals(IphoneMotherBoard.class, phone.getMotherBoard().getClass());
        assertEquals(IphoneProcessor.class, phone.getProcessor().getClass());
        assertEquals(Battery.class, phone.getBattery().getClass());
    }
}
