package com.directi.training.designpatterns.decorator;

public class TOEFL extends GPAEval
{
    @Override
    public boolean evaluate(Application theApp)
    {
        return super.evaluate(theApp) && theApp.getToefl() > 100;
    }
}
