package com.directi.training.designpatterns_refactored.strategy;

public class AtLeast implements Validation
{
    private final int _min;

    public AtLeast(int min)
    {
        _min = min;
    }

    @Override
    public void validate(Object name) throws ValidationFailedException
    {
        Integer val = (Integer) name;
        if (val < _min) {
            throw new ValidationFailedException("at least check failed:" + val);
        }
    }
}
