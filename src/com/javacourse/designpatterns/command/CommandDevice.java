package com.javacourse.designpatterns.command;

public class CommandDevice {

    public void pressButton(ICommand command) {
        command.execute();
    }
}
