package MultiThreading.Locks.ReentrantLock;

import MultiThreading.Locks.ReentrantLock.SharedResource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


        /*
        Even though we have 2 sharedResources lock will be acqured by only thread at once since both threads are using same lock
        When ever a thread acquires a lock, other threads using same lock will wait until the lock gets released
         */

public class Main {
    // https://www.udemy.com/course/both-java-springboot-basics-to-advanced/learn/lecture/46410639#overview
    public static void main(String[] args) throws InterruptedException {

        SharedResource sharedResource1 = new SharedResource();
        SharedResource sharedResource2 = new SharedResource();
        SharedResource sharedResource3 = new SharedResource();


        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> sharedResource1.addItem(lock), "Thread-1");

        Thread t2 = new Thread(() -> sharedResource2.consumeItem(lock), "Thread-2");

        Thread t3 = new Thread(() -> sharedResource3.consumeItem(lock), "Thread-3");

        t1.start();
        t2.start();
        t3.start();

//        System.out.println("state of " + t1.getName() + " is " + t1.getState());
//
//        System.out.println("state of " + t2.getName() + " is " + t2.getState());
//
//        Thread.sleep(4000);
//        System.out.println("state of " + t2.getName() + " is " + t2.getState());
//
//        System.out.println("state of " + t3.getName() + " is " + t3.getState());

        System.out.println("main method completed execution");
    }
}
