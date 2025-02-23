package com.dp.observer.example1;

public interface Observable<T> {

    void addObservers(Observer observer);
    void removeObservers(Observer observer);
    void notifyObservers();
}
