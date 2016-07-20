package com.directi.training.designpatterns.observer;

public class Dog
{
    private boolean _outdoors;
    private boolean _feelingWarm;
    private boolean _feelingTired;

    public boolean isOutdoors()
    {
        return _outdoors;
    }

    public boolean isFeelingWarm()
    {
        return _feelingWarm;
    }

    public boolean isFeelingTired()
    {
        return _feelingTired;
    }

    public void goOutdoors()
    {
        _outdoors = true;
    }

    public void goIndoors()
    {
        _outdoors = false;
        _feelingTired = true;
    }

    public void notifySunRose()
    {
        _feelingWarm = true;
    }

    public void notifySunSet()
    {
        _feelingWarm = false;
        if (_outdoors) {
            _feelingTired = true;
        }
    }
}
