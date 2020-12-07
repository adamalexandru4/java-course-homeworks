package com.javacourse.designpatterns.command.audio;

import com.javacourse.designpatterns.command.ICommand;
import com.javacourse.designpatterns.command.audio.Audio;

public class TurnVolumeUp implements ICommand {

    private Audio audio;

    public TurnVolumeUp(Audio audio) {
        super();
        this.audio = audio;
    }

    @Override
    public void execute() {
        audio.turnVolumeUp();
    }
}
