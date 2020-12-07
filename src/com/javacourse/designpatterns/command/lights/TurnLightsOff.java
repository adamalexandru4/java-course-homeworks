package com.javacourse.designpatterns.command.lights;

import com.javacourse.designpatterns.command.ICommand;

public class TurnLightsOff implements ICommand {

    private Lights lights;

    public TurnLightsOff(Lights lights) {
        super();
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.turnOff();
    }
}
