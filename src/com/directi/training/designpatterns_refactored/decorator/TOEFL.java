package com.directi.training.designpatterns_refactored.decorator;

public class TOEFL extends CriteriaDecorator
{
    protected TOEFL(Criteria previousCriteria)
    {
        super(previousCriteria);
    }

    @Override
    public boolean performEvaluate(Application theApp)
    {
        return theApp.getToefl() > 100;
    }
}
