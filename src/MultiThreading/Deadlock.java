package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {

    Lock lock;

    public void outMethod(){
        lock.lock();
        try{
            System.out.println("outer method");
            innerMethod();
        } finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try{
            System.out.println("inner method");
        }finally {
            lock.unlock();
        }
    }
}
