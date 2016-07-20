package com.directi.training.designpatterns_refactored.observer;

public abstract class Character implements ISunSubscriber
{
    private boolean _feelingWarm;
    private Sun _sun;
    private boolean _feelingTired;
    private boolean _outdoors = false;

    public Character(Sun sun)
    {
        _sun = sun;
    }

    @Override
    public void notifySunRose()
    {
        _feelingWarm = true;
    }

    @Override
    public void notifySunSet()
    {
        _feelingWarm = false;
        _feelingTired = true;
    }

    public boolean isFeelingWarm()
    {
        return _feelingWarm;
    }

    public boolean isOutdoors()
    {
        return _outdoors;
    }

    public boolean isFeelingTired()
    {
        return _feelingTired;
    }

    public void goOutdoors()
    {
        _outdoors = true;
        _sun.subscribe(this);
        if (_sun.isUp()) {
            _feelingWarm = true;
        }
    }

    public void goIndoors()
    {
        _outdoors = false;
        _sun.unsubscribe(this);
        if (!_sun.isUp()) {
            _feelingWarm = false;
        }
    }
}
