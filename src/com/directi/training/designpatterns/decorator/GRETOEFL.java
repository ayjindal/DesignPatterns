package com.directi.training.designpatterns.decorator;

public class GRETOEFL extends GPAEval
{
    @Override
    public boolean evaluate(Application theApp)
    {
        return super.evaluate(theApp) && theApp.getGre() > 1450 && theApp.getToefl() > 100;
    }
}
