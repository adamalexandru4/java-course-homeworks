package com.javacourse.designpatterns.observer;

public class Children2 implements IObserver {
    @Override
    public void addHistoryMessage() {
        System.out.println("History message from children 2");
    }

    @Override
    public void updateChildren() {
        System.out.println("Children 2 updated");
    }
}
