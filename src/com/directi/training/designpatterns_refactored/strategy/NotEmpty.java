package com.directi.training.designpatterns_refactored.strategy;

public class NotEmpty implements Validation
{
    @Override
    public void validate(Object val) throws ValidationFailedException
    {
        if (val == null || ((String) val).length() == 0) {
            throw new ValidationFailedException("not empty check failed for value:" + val);
        }
    }
}
