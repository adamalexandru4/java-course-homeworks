package com.javacourse.designpatterns.strategy;

public class FirstNameFirst implements IStrategy {

    @Override
    public void execute(String firstName, String lastName) {
        System.out.println(firstName + " " + lastName);
    }
}
