package Java.MultiThreading.Locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceUsingReadWriteLock {

    private boolean isAvailable = false;
    public void addItem(StampedLock lock) {
        long stamp = lock.readLock();
        try {
            // In the operations below we shouldn't change the value of the resource
            System.out.println("AddItem, ReadLock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("AddItem, ReadLock released by: "+ Thread.currentThread().getName());
            lock.unlockRead(stamp);
        }
    }

    public void consumeItem(StampedLock lock){
        long stamp = lock.writeLock();
        try {
            System.out.println("consumeItem , WriteLock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("consumeItem , WriteLock released by: "+ Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}
