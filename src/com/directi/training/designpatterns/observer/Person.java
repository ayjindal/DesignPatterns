package com.directi.training.designpatterns.observer;

public class Person
{
    private boolean _feelingWarm;
    private boolean _outdoors;
    private boolean _feelingTired;

    public boolean isFeelingWarm()
    {
        return _feelingWarm;
    }

    public void goOutdoors()
    {
        _outdoors = true;
    }

    public void goIndoors()
    {
        _outdoors = false;
    }

    public boolean isOutdoors()
    {
        return _outdoors;
    }

    public void notifySunRose()
    {
        if (_outdoors) {
            _feelingWarm = true;
        }
    }

    public void notifySunSet()
    {
        _feelingWarm = false;
        if (_outdoors) {
            _feelingTired = true;
        }
    }

    public boolean isFeelingTired()
    {
        return _feelingTired;
    }
}
