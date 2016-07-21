package com.directi.training.designpatterns.decorator;

public class Application
{
    private final float _gpa;
    private final float _gre;
    private final float _toefl;

    public Application(float gpa, float gre, float toefl)
    {
        _gpa = gpa;
        _gre = gre;
        _toefl = toefl;
    }

    public float getGpa()
    {
        return _gpa;
    }

    public float getGre()
    {
        return _gre;
    }

    public float getToefl()
    {
        return _toefl;
    }
}
