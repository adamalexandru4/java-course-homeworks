package com.javacourse.designpatterns.strategy;

@FunctionalInterface
public interface IStrategy{

    void execute(String firstName, String lastName);
}
