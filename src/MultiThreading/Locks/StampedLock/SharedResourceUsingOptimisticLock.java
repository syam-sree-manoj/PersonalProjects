package MultiThreading.Locks.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class SharedResourceUsingOptimisticLock {

    private int a = 10;
    public void addItem(StampedLock lock) {
        long stamp = lock.tryOptimisticRead();
        try {
            // In the operations below we shouldn't change the value of the resource
            System.out.println("Taken optimistic read by : " + Thread.currentThread().getName());
            a = 11;
            Thread.sleep(4000);
            if(lock.validate(stamp)){
                System.out.println("updated a value successfully");
            }else {
                System.out.println("rollback of work done");
                a = 10;
            }
        } catch (Exception e){
            // handle exception
        }
        /*
        Since optimistic lock is not a lock actually, we need not release the lock.
         */
    }

    public void consumeItem(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("consumeItem , WriteLock acquired by : " + Thread.currentThread().getName());
        try {
            Thread.sleep(4000);
            a = 9;
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("consumeItem , WriteLock released by: "+ Thread.currentThread().getName());
            lock.unlockWrite(stamp);
        }
    }
}

