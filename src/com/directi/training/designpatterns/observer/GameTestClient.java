package com.directi.training.designpatterns.observer;

public class GameTestClient
{
    public Person _person;
    public Sun _sun;
    public Dog _dog;
    public Cat _cat;
    public Robot _robot;
    public Game game;

    public void setup()
    {
        _person = new Person();
        _dog = new Dog();
        _cat = new Cat();
        _robot = new Robot();
        _sun = new Sun(_robot, _person, _dog, _cat);
        game = new Game(_sun);
    }

    public void everyoneGoesOut()
    {
        _person.goOutdoors();
        _robot.goOutdoors();
        _dog.goOutdoors();
        _cat.goOutdoors();
    }

    public void everyoneOutdoorsComesIn()
    {
        if (_person.isOutdoors()) {
            _person.goIndoors();
        }
        if (_robot.isOutdoors()) {
            _robot.goIndoors();
        }
        if (_cat.isOutdoors()) {
            _cat.goIndoors();
        }
        if (_dog.isOutdoors()) {
            _dog.goIndoors();
        }
    }

    public void tickOnce()
    {
        game.tick();
    }

    public void tickTwice()
    {
        game.tick();
        game.tick();
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

    public boolean allFeelCold()
    {
        return !_person.isFeelingWarm() && !_cat.isFeelingWarm() && !_dog.isFeelingWarm() &&
               !_robot.isFeelingWarm();
    }
}