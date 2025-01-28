package LLD.DesignPatterns.ObserverDesignPattern;

import LLD.DesignPatterns.ObserverDesignPattern.observable.IphoneObservable;
import LLD.DesignPatterns.ObserverDesignPattern.observable.RealmeObservable;
import LLD.DesignPatterns.ObserverDesignPattern.observer.NotifyOverEmailObserver;
import LLD.DesignPatterns.ObserverDesignPattern.observer.NotifyOverMobileObserver;

public class Main {
    public static void main(String[] args) {

        IphoneObservable iphoneObservable = new IphoneObservable();
        RealmeObservable realmeObservable = new RealmeObservable();

        NotifyOverEmailObserver notifyOverEmailObserver = new NotifyOverEmailObserver(iphoneObservable);
        notifyOverEmailObserver.addEmail("syamsreemanoj@gmail.com");
        notifyOverEmailObserver.addEmail("vijyaLakshmi@gmail.com");

        NotifyOverMobileObserver notifyOverMobileObserver = new NotifyOverMobileObserver(iphoneObservable);
        notifyOverMobileObserver.addPhone("9182825717");
        notifyOverMobileObserver.addPhone("9666835387");


        NotifyOverEmailObserver notifyOverEmailObserver1 = new NotifyOverEmailObserver(realmeObservable);
        notifyOverEmailObserver1.addEmail("realme-syamsreemanoj@gmail.com");
        notifyOverEmailObserver1.addEmail("realme-vijyaLakshmi@gmail.com");

        NotifyOverMobileObserver notifyOverMobileObserver1 = new NotifyOverMobileObserver(realmeObservable);
        notifyOverMobileObserver1.addPhone("realme-9182825717");
        notifyOverMobileObserver1.addPhone("realme-9666835387");

        iphoneObservable.add(notifyOverEmailObserver);
        iphoneObservable.add(notifyOverMobileObserver);

        realmeObservable.add(notifyOverEmailObserver1);
        realmeObservable.add(notifyOverMobileObserver1);

        iphoneObservable.setData(10);
        realmeObservable.setData(20);
    }
}
