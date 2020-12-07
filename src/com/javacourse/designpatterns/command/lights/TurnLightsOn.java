package com.javacourse.designpatterns.command.lights;

import com.javacourse.designpatterns.command.ICommand;

public class TurnLightsOn implements ICommand {

    private Lights lights;

    public TurnLightsOn(Lights lights) {
        super();
        this.lights = lights;
    }

    @Override
    public void execute() {
        lights.turnOn();
    }
}
