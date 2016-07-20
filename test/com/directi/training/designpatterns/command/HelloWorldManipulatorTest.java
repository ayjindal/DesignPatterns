package com.directi.training.designpatterns.command;

import org.junit.After;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class HelloWorldManipulatorTest
{
    @Test
    public void testManipulate() throws IOException
    {
        HelloWorldManipulator manipulator = new HelloWorldManipulator();
        manipulator.manipulate("foo.txt", "bar.txt");

        BufferedReader reader = new BufferedReader(new FileReader(new File("bar.txt")));
        String aLine;
        String theContent = "";
        while ((aLine = reader.readLine()) != null) {
            theContent += aLine;
        }
        reader.close();
        assertEquals("new hello world", theContent);
        assertFalse(new File("foo.txt").exists());
    }

    @Test
    public void testBrokenManipulate() throws FileNotFoundException
    {
        HelloWorldManipulator manipulator = new HelloWorldManipulator();
        manipulator.brokenManipulate("foo.txt", "bar.txt");
        assertFalse(new File("foo.txt").exists());
        assertFalse(new File("bar.txt").exists());
    }

    @After
    public void after()
    {
        File file = new File("foo.txt");
        file.delete();
        file = new File("bar.txt");
        file.delete();
    }
}
