package com.directi.training.designpatterns_refactored.command;

import java.io.File;

public class MoveFileCommand implements Command
{
    private final String _oldPath;
    private final String _newPath;

    public MoveFileCommand(String oldPath, String newPath)
    {
        _oldPath = oldPath;
        _newPath = newPath;
    }

    @Override
    public void rollback()
    {
        move(_newPath, _oldPath);
    }

    @Override
    public void execute()
    {
        move(_oldPath, _newPath);
    }

    private void move(final String source, final String destination)
    {
        File file = new File(source);
        if (!file.exists()) {
            throw new RuntimeException("File: " + _oldPath + " does not exist");
        }
        if (!file.renameTo(new File(destination))) {
            throw new RuntimeException("Rename failed");
        }
    }
}
