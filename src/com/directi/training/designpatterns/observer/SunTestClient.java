package com.directi.training.designpatterns.observer;

public class SunTestClient
{
    private final Person _person;
    private final Cat _cat;
    private final Dog _dog;
    private final Robot _robot;
    private Sun _sun;

    public SunTestClient()
    {
        _person = new Person();
        _cat = new Cat();
        _dog = new Dog();
        _robot = new Robot();
        _sun = new Sun(_robot, _person, _dog, _cat);
    }

    public void aFewCharactersGoOutdoors()
    {
        _person.goOutdoors();
        _robot.goOutdoors();
    }

    public void aFewOtherCharactersGoOutdoors()
    {
        _cat.goOutdoors();
        _dog.goOutdoors();
    }

    public void sunRise()
    {
        _sun.rise();
    }

    public void sunSet()
    {
        _sun.set();
    }

    public boolean outdoorsCharactersFeelTired()
    {
        if (_person.isOutdoors() && !_person.isFeelingTired()) {
            return false;
        }
        if (_robot.isOutdoors() && !_robot.isFeelingTired()) {
            return false;
        }
        if (_cat.isOutdoors() && !_cat.isFeelingTired()) {
            return false;
        }
        if (_dog.isOutdoors() && !_dog.isFeelingTired()) {
            return false;
        }
        return true;
    }

    public boolean outdoorsCharactersFeelWarm()
    {
        if (_person.isOutdoors() && !_person.isFeelingWarm()) {
            return false;
        }
        if (_cat.isOutdoors() && !_cat.isFeelingWarm()) {
            return false;
        }
        if (_dog.isOutdoors() && !_dog.isFeelingWarm()) {
            return false;
        }
        if (_robot.isOutdoors() && !_robot.isFeelingWarm()) {
            return false;
        }

        if (!_person.isOutdoors() && _person.isFeelingWarm()) {
            return false;
        }
        if (!_cat.isOutdoors() && _cat.isFeelingWarm()) {
            return false;
        }
        if (!_dog.isOutdoors() && _dog.isFeelingWarm()) {
            return false;
        }
        if (!_robot.isOutdoors() && _robot.isFeelingWarm()) {
            return false;
        }
        return true;
    }
}
