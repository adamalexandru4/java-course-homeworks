package com.javacourse.designpatterns.strategy;

public class StrategyContext {

    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(String firstName, String lastName) {
        strategy.execute(firstName, lastName);
    }
}
