package com.javacourse.designpatterns.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BusyObject {

    private Integer id;
    private String name;
    private LocalDate creationDate = LocalDate.now().minusDays(1);
    private final List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        observers.remove(observer);
    }

    public void updateObjectAndDependencies(String name, LocalDate creationDate) {
        this.name = name;
        if (creationDate.isBefore(this.creationDate)) {
            throw new IllegalArgumentException("The date can't be set before the original creation date");
        }
        this.creationDate = creationDate;
        observers.forEach(IObserver::receiveNotification);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
