package com.javacourse.designpatterns.command;

public class CommandDevice {

    ICommand command;

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}
