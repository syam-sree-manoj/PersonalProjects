package MultiThreading.Locks.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class SharedResource {

    private boolean isAvailable = false;
    public void addItem(Lock lock){
        Condition condition = lock.newCondition();
        try {
            lock.lock();
            System.out.println("AddItem, Lock acquired by : " + Thread.currentThread().getName());
            if(isAvailable){
                System.out.println("Producer thread is waiting" + Thread.currentThread().getName());
                condition.await();
            }
            isAvailable = true;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("AddItem, Lock released by: "+ Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void consumeItem(Lock lock){
        try {
            lock.lock();
            System.out.println("consumeItem , Lock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("consumeItem , Lock released by: "+ Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
