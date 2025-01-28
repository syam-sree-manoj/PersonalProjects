package LLD.DesignPatterns.ObserverDesignPattern.observer;

import LLD.DesignPatterns.ObserverDesignPattern.observable.Observable;
import java.util.*;

public class NotifyOverEmailObserver implements Observer {

    List<String> emailIDList;

    Observable observable;

    public NotifyOverEmailObserver(Observable observable){
        this.emailIDList = new ArrayList<>();
        this.observable = observable;
    }

    public void addEmail(String emailID){
        emailIDList.add(emailID);
    }

    @Override
    public void update() {
        int availableStockCount = observable.getData();
        sendEmail(availableStockCount);
    }

    private void sendEmail(int availableStockCount){
        for(String emailID : emailIDList){
            System.out.println("mail sent to : " + emailID + " with stockCount " + availableStockCount);
        }
    }
}
