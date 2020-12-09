package com.javacourse.designpatterns.observer;

public class Children1 implements IObserver{

    public void addHistoryMessage() {
        System.out.println("History from children 1");
    }

    public void updateChildren() {
        System.out.println("Children 1 updated");
    }

    @Override
    public void receiveNotification() {
        addHistoryMessage();
        updateChildren();
    }
}
