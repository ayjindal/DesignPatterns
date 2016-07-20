package com.directi.training.designpatterns_refactored.observer;

public class CharacterTestClient
{
    private Cat _cat;
    private Person _person;
    private Dog _dog;
    private Robot _robot;

    public CharacterTestClient()
    {
        Sun sun = new Sun();

        _robot = new Robot(sun);
        _dog = new Dog(sun);
        _person = new Person(sun);
        _cat = new Cat(sun);
    }

    public boolean testOutdoors()
    {
        _robot.goOutdoors();
        _person.goOutdoors();
        _cat.goOutdoors();
        _dog.goOutdoors();
        return _robot.isOutdoors() && _person.isOutdoors() && _cat.isOutdoors() &&
               _dog.isOutdoors();
    }

    public boolean testSunRose()
    {
        _robot.notifySunRose();
        _person.notifySunRose();
        _cat.notifySunRose();
        _dog.notifySunRose();
        return _robot.isFeelingWarm() && _person.isFeelingWarm() && _cat.isFeelingWarm() &&
               _dog.isFeelingWarm();
    }

    public boolean testSunSet()
    {
        _robot.notifySunSet();
        _person.notifySunSet();
        _cat.notifySunSet();
        _dog.notifySunSet();
        return !_robot.isFeelingWarm() && !_person.isFeelingWarm() && !_cat.isFeelingWarm() &&
               !_dog.isFeelingWarm();
    }

    public boolean testIndoors()
    {
        _robot.goIndoors();
        _person.goIndoors();
        _cat.goIndoors();
        _dog.goIndoors();
        return !_robot.isOutdoors() && !_person.isOutdoors() && !_cat.isOutdoors() &&
               !_dog.isOutdoors();
    }
}
