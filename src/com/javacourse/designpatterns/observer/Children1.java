package com.javacourse.designpatterns.observer;

public class Children1 implements IObserver{

    @Override
    public void addHistoryMessage() {
        System.out.println("History from children 1");
    }

    @Override
    public void updateChildren() {
        System.out.println("Children 1 updated");
    }
}
