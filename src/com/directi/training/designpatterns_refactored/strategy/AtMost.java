package com.directi.training.designpatterns_refactored.strategy;

public class AtMost implements Validation
{
    private final int _max;

    public AtMost(int max)
    {
        _max = max;
    }

    @Override
    public void validate(Object name) throws ValidationFailedException
    {
        Integer val = (Integer) name;
        if (val > _max) {
            throw new ValidationFailedException("at most check failed:" + val);
        }
    }
}
