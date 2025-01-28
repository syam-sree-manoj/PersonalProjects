package LLD.DesignPatterns.ObserverDesignPattern.observable;

import LLD.DesignPatterns.ObserverDesignPattern.observer.Observer;

public interface Observable {

    // add observer object
    void add(Observer observer);

    void remove(Observer observer);

    void notifyObservers();

    void setData(int data);

    int getData();
}
