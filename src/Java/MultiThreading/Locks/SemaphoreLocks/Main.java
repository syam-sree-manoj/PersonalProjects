package Java.MultiThreading.Locks.SemaphoreLocks;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore lock = new Semaphore(2);
        SharedResource sharedResource = new SharedResource();

        Thread t1 = new Thread(() -> sharedResource.addItem(lock), "Thread-1");

        Thread t2 = new Thread(() -> sharedResource.addItem(lock), "Thread-2");

        Thread t3 = new Thread(() -> sharedResource.addItem(lock), "Thread-3");
        Thread t4 = new Thread(() -> sharedResource.addItem(lock), "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
