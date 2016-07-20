package com.directi.training.designpatterns.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldManipulator
{
    public void manipulate(final String fileName, final String newPath)
    {
        int count = 0;
        try {
            create(fileName, "hello world");
            count = 1;
            update(fileName, "new hello world");
            count = 2;
            move(fileName, newPath);
            count = 3;
        } catch (Exception e) {
            switch (count) {
            case 2:
                update(fileName, "hello world");
            case 1:
                delete(fileName);

            }
        }
    }

    private void delete(String fileName)
    {
        File file = new File(fileName);
        file.delete();
    }

    private void move(String source, String destination)
    {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist");
        }
        if (!file.renameTo(new File(destination))) {
            throw new RuntimeException("Rename failed");
        }
    }

    private void update(String fileName, String content)
    {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new RuntimeException("File: " + fileName + " does not exist");
        }
        try {

            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void brokenManipulate(String fileName, String newPath)
    {
        int count = 0;
        try {
            create(fileName, "hello world");
            count = 1;
            update(fileName, "new hello world");
            count = 2;
            move(fileName, newPath);
            count = 3;
            create(fileName, "hello world");
            count = 4;
            create(fileName, "hello world");
            count = 5;
        } catch (Exception e) {
            switch (count) {
            case 4:
                delete(fileName);
            case 3:
                move(newPath, fileName);
            case 2:
                update(fileName, "hello world");
            case 1:
                delete(fileName);
            }
        }
    }

    private void create(String fileName, String content)
    {
        File file = new File(fileName);
        if (file.exists()) {
            throw new RuntimeException("File already exists");
        }
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
