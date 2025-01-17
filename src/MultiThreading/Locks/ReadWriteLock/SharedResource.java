package MultiThreading.Locks.ReadWriteLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    private boolean isAvailable = false;
    public void addItem(ReadWriteLock lock) {
        try {
            lock.readLock().lock();
            // In the operations below we shouldn't change the value of the resource
            System.out.println("AddItem, ReadLock acquired by : " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("AddItem, ReadLock released by: "+ Thread.currentThread().getName());
            lock.readLock().unlock();
        }
    }

    public void consumeItem(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("consumeItem , WriteLock acquired by : " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e){
            // handle exception
        } finally {
            System.out.println("consumeItem , WriteLock released by: "+ Thread.currentThread().getName());
            lock.writeLock().unlock();
        }
    }
}
