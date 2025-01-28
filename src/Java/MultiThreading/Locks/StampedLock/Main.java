package Java.MultiThreading.Locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class Main {
    // https://www.udemy.com/course/both-java-springboot-basics-to-advanced/learn/lecture/46410639#overview
    public static void main(String[] args) {

        SharedResourceUsingOptimisticLock sharedResourceUsingOptimisticLock = new SharedResourceUsingOptimisticLock();
        SharedResourceUsingReadWriteLock sharedResourceUsingReadWriteLock = new SharedResourceUsingReadWriteLock();

        StampedLock stampedLock = new StampedLock();

        Thread t1 = new Thread(() -> sharedResourceUsingReadWriteLock.addItem(stampedLock), "Thread-1");
        Thread t2 = new Thread(() -> sharedResourceUsingReadWriteLock.addItem(stampedLock), "Thread-2");
        Thread t3 = new Thread(() -> sharedResourceUsingReadWriteLock.consumeItem(stampedLock), "Thread-3");

//        Thread t4 = new Thread(() -> sharedResourceUsingOptimisticLock.addItem(stampedLock), "Thread-4");
//        Thread t5 = new Thread(() -> sharedResourceUsingOptimisticLock.consumeItem(stampedLock), "Thread-5");

        t1.start();
        t2.start();
        t3.start();

//        t4.start();
//        t5.start();

    }
}
