package LLD.DesignPatterns.ObserverDesignPattern.observable;

import LLD.DesignPatterns.ObserverDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements Observable {

    List<Observer> observerList;
    int stockCount;

    public IphoneObservable(){
        observerList = new ArrayList<>();
    }


    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer : observerList){
            observer.update();
        }
    }

    @Override
    public void setData(int newStockCount) {
        if(stockCount == 0 && newStockCount > 0){
            stockCount = newStockCount;
            notifyObservers();
            return;
        }
        stockCount = newStockCount;
    }

    @Override
    public int getData() {
        return this.stockCount;
    }
}
