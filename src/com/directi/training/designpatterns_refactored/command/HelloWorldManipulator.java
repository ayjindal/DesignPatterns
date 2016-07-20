package com.directi.training.designpatterns_refactored.command;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldManipulator
{
    public void manipulate(final String fileName, final String newPath)
    {
        List<Command> commands = new ArrayList<>(3);
        commands.add(new CreateFileCommand(fileName, "hello world"));
        commands.add(new UpdateFileCommand(fileName, "new hello world"));
        commands.add(new MoveFileCommand(fileName, newPath));
        new FileManipulator().perform(commands);
    }

    public void brokenManipulate(final String fileName, final String newPath)
    {
        List<Command> commands = new ArrayList<>(5);
        commands.add(new CreateFileCommand(fileName, "hello world"));
        commands.add(new UpdateFileCommand(fileName, "new hello world"));
        commands.add(new MoveFileCommand(fileName, newPath));
        commands.add(new CreateFileCommand(fileName, "hello world"));
        commands.add(new CreateFileCommand(fileName, "hello world"));
        new FileManipulator().perform(commands);
    }
}
