package com.directi.training.designpatterns_refactored.command;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFileCommand implements Command
{
    private final String _fileName;
    private final String _content;

    public CreateFileCommand(String fileName, String content)
    {
        _fileName = fileName;
        _content = content;
    }

    @Override
    public void rollback()
    {
        File file = new File(_fileName);
        file.delete();
    }

    @Override
    public void execute()
    {
        File file = new File(_fileName);
        if (file.exists()) {
            throw new RuntimeException("File already exists");
        }
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(file);
            writer.write(_content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
