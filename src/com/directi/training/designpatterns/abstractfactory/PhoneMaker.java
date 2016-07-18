package com.directi.training.designpatterns.abstractfactory;

public class PhoneMaker
{
    private static final String ANDROID = "Android";

    public Case buildPhone(String phoneType)
    {
        MotherBoard motherBoard;
        if (phoneType.equals(ANDROID)) {
            motherBoard = new AndroidMotherBoard();
            motherBoard.attachBattery(new Battery());
            motherBoard.attachProcessor(new AndroidProcessor());
        } else {
            motherBoard = new IphoneMotherBoard();
            motherBoard.attachBattery(new Battery());
            motherBoard.attachProcessor(new IphoneProcessor());
        }

        Screen screen;
        if (phoneType.equals(ANDROID)) {
            screen = new AndroidScreen();
        } else {
            screen = new IphoneScreen();
        }

        Case phoneCase;
        if (phoneType.equals(ANDROID)) {
            phoneCase = new AndroidCase();
        } else {
            phoneCase = new IphoneCase();
        }
        phoneCase.attachMotherBoard(motherBoard);
        phoneCase.attachScreen(screen);
        return phoneCase;
    }
}
