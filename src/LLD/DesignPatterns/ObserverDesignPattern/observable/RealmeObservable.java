package LLD.DesignPatterns.ObserverDesignPattern.observable;

import LLD.DesignPatterns.ObserverDesignPattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class RealmeObservable implements Observable{

    int stockCount;
    List<Observer> observerList;

    public RealmeObservable(){
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
        for(Observer ob : observerList){
            ob.update();
        }
    }

    @Override
    public void setData(int newStockCount) {
        if(stockCount == 0 && newStockCount > 0){
            this.stockCount = newStockCount;
            notifyObservers();
            return;
        }
        this.stockCount = newStockCount;
    }

    @Override
    public int getData() {
        return stockCount;
    }
}
