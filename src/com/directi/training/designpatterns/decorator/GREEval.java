package com.directi.training.designpatterns.decorator;

public class GREEval extends GPAEval
{
    @Override
    public boolean evaluate(Application theApp)
    {
        if (super.evaluate(theApp)) {
            System.out.println("GREEval called");
            return theApp.getGre() > 1450;
        } else {
            return false;
        }
    }
}
