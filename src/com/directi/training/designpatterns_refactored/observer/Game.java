package com.directi.training.designpatterns_refactored.observer;

import java.util.ArrayList;
import java.util.List;

public class Game
{
    private Sun _sun;
    private List<Character> _characters = new ArrayList<>(4);

    public Game(Sun sun)
    {
        _sun = sun;
    }

    public void tick()
    {
        if (_sun.isUp()) {
            _sun.set();
        } else {
            _sun.rise();
        }
    }

    public void add(Character character)
    {
        _characters.add(character);
    }

    public List<Character> getCharacters()
    {
        return _characters;
    }
}

