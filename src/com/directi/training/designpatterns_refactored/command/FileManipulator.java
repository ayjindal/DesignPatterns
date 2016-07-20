package com.directi.training.designpatterns_refactored.command;

import java.util.ArrayList;
import java.util.List;

public class FileManipulator
{
    public void perform(List<Command> commands)
    {
        List<Command> executedCommands = new ArrayList<>();
        try {
            for (Command command : commands) {
                command.execute();
                executedCommands.add(command);
            }
        } catch (Exception e) {
            for (int i = executedCommands.size() - 1; i >= 0; i--) {
                executedCommands.get(i).rollback();
            }
        }
    }
}
