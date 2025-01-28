package Java.MultiThreading.Locks.SemaphoreLocks;

import java.util.concurrent.Semaphore;


public class SharedResource {

    private boolean isAvailable = false;
    public void addItem(Semaphore lock){
        try {
            lock.acquire();
            System.out.println("AddItem, Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("AddItem, Lock released by: "+ Thread.currentThread().getName());
            lock.release();
        }
    }

    public void consumeItem(Semaphore lock){
        try {
            lock.acquire();
            System.out.println("consumeItem , Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("consumeItem , Lock released by: "+ Thread.currentThread().getName());
            lock.release();
        }
    }
}
