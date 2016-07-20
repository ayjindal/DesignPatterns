package com.directi.training.designpatterns_refactored.observer;

import java.util.ArrayList;
import java.util.List;

public class GameTestClient
{
    public Person _person;
    public Sun _sun;
    public Dog _dog;
    public Cat _cat;
    public Robot _robot;
    public Game _game;

    public void setup()
    {
        _sun = new Sun();
        _person = new Person(_sun);
        _dog = new Dog(_sun);
        _cat = new Cat(_sun);
        _robot = new Robot(_sun);
        _game = new Game(_sun);
        for (Character character : getCharacters()) {
            _game.add(character);
        }
    }

    public void everyoneGoesOut()
    {
        for (Character character : _game.getCharacters()) {
            character.goOutdoors();
        }
    }

    public void everyoneOutdoorsComesIn()
    {
        for (Character character : _game.getCharacters()) {
            if (character.isOutdoors()) {
                character.goIndoors();
            }
        }
    }

    public void tickOnce()
    {
        _game.tick();
    }

    public void tickTwice()
    {
        _game.tick();
        _game.tick();
    }

    public boolean outdoorsCharactersFeelWarm()
    {
        for (Character character : _game.getCharacters()) {
            if (isOutdoorsAndFeelsCold(character) || isIndoorsAndFeelsWarm(character)) {
                return false;
            }
        }
        return true;
    }

    private boolean isIndoorsAndFeelsWarm(Character character)
    {
        return !character.isOutdoors() && character.isFeelingWarm();

    }

    private boolean isOutdoorsAndFeelsCold(Character character)
    {
        return character.isOutdoors() && !character.isFeelingWarm();

    }

    public boolean allFeelCold()
    {
        return !_person.isFeelingWarm() && !_cat.isFeelingWarm() && !_dog.isFeelingWarm() &&
               !_robot.isFeelingWarm();
    }

    private List<Character> getCharacters()
    {
        return new ArrayList<Character>()
        {
            {
                add(_person);
                add(_dog);
                add(_cat);
                add(_robot);
            }
        };
    }
}