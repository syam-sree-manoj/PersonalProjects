package LLD.DesignPatterns.ObserverDesignPattern.observer;

import LLD.DesignPatterns.ObserverDesignPattern.observable.Observable;

import java.util.ArrayList;
import java.util.List;

public class NotifyOverMobileObserver implements Observer {
    Observable observable;
    List<String> phoneNoList;

    public NotifyOverMobileObserver(Observable observable){
        this.observable = observable;
        phoneNoList = new ArrayList<>();
    }

    public void addPhone(String phoneNo){
        phoneNoList.add(phoneNo);
    }

    @Override
    public void update() {
        int availableStockCount = observable.getData();
        sendMessage(availableStockCount);
    }

    private void sendMessage(int availableStockCount) {
        for(String phoneNo : phoneNoList){
            System.out.println("Message sent to : " + phoneNo + " with availableStockCount " + availableStockCount);
        }
    }

}
