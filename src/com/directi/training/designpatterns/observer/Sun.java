package com.directi.training.designpatterns.observer;

public class Sun
{
    private final Robot _robot;
    private final Person _person;
    private final Dog _dog;
    private final Cat _cat;
    private boolean _up;

    public Sun(Robot robot, Person person, Dog dog, Cat cat)
    {
        _robot = robot;
        _person = person;
        _dog = dog;
        _cat = cat;
    }

    public boolean isUp()
    {
        return _up;
    }

    public void set()
    {
        _up = false;

        if (_robot.isOutdoors()) {
            _robot.notifySunSet();
        }

        if (_person.isOutdoors()) {
            _person.notifySunSet();
        }

        if (_dog.isOutdoors()) {
            _dog.notifySunSet();
        }

        if (_cat.isOutdoors()) {
            _cat.notifySunSet();
        }
    }

    public void rise()
    {
        _up = true;

        if (_robot.isOutdoors()) {
            _robot.notifySunRose();
        }

        if (_person.isOutdoors()) {
            _person.notifySunRose();
        }

        if (_dog.isOutdoors()) {
            _dog.notifySunRose();
        }

        if (_cat.isOutdoors()) {
            _cat.notifySunRose();
        }
    }
}