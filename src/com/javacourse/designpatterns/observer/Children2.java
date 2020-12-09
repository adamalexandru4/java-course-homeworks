package com.javacourse.designpatterns.observer;

public class Children2 implements IObserver {

    public void addHistoryMessage() {
        System.out.println("History message from children 2");
    }

    public void updateChildren() {
        System.out.println("Children 2 updated");
    }

    @Override
    public void receiveNotification() {
        addHistoryMessage();
        updateChildren();
    }
}
