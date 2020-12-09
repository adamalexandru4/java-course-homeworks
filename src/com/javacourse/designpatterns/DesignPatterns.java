package com.javacourse.designpatterns;

import com.javacourse.designpatterns.command.CommandDevice;
import com.javacourse.designpatterns.command.audio.Audio;
import com.javacourse.designpatterns.command.audio.TurnVolumeUp;
import com.javacourse.designpatterns.command.lights.Lights;
import com.javacourse.designpatterns.command.lights.TurnLightsOff;
import com.javacourse.designpatterns.observer.BusyObject;
import com.javacourse.designpatterns.observer.Children1;
import com.javacourse.designpatterns.observer.Children2;
import com.javacourse.designpatterns.strategy.FirstNameFirst;
import com.javacourse.designpatterns.strategy.LastNameFirst;
import com.javacourse.designpatterns.strategy.StrategyContext;

import java.io.IOException;
import java.time.LocalDate;

public class DesignPatterns {

    public static void main(String[] args) {

        // Command pattern
        /** COMMAND = MAKE AN OBJECT OF WHAT NEEDS TO BE DONE **/
        Lights lights = new Lights();
        Audio audio = new Audio();

        CommandDevice commandDevice = new CommandDevice();

        commandDevice.pressButton(new TurnLightsOff(lights));
        commandDevice.pressButton(new TurnVolumeUp(audio));

        // Strategy pattern
        /** STRATEGY = HOW SOMETHING SHOULD BE DONE  **/
        StrategyContext strategyContext = new StrategyContext();

        strategyContext.setStrategy((firstName, lastName) -> System.out.println(firstName + " " + lastName ));
//        strategyContext.setStrategy(new FirstNameFirst());
        strategyContext.execute("Alex", "Adam");

        strategyContext.setStrategy((firstName, lastName) -> System.out.println(lastName + " " + firstName));
        strategyContext.execute("Alex", "Adam");

        // Facade pattern
//        HttpConnectionHandlerFacade httpConnectionHandlerFacade = new HttpConnectionHandlerFacade(new URL("https://www.google.ro"));
//        httpConnectionHandlerFacade.consume("POST", "Body message");
//        httpConnectionHandlerFacade.consume("GET", null);

        // Observer pattern
        BusyObject busyObject = new BusyObject();

        Children1 children1 = new Children1();
        busyObject.addObserver(children1);
        Children2 children2 = new Children2();
        busyObject.addObserver(children2);

        busyObject.updateObjectAndDependencies("Adam", LocalDate.now());

        busyObject.removeObserver(children1);
        busyObject.updateObjectAndDependencies("Adam", LocalDate.now());

    }
}
