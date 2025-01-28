package Java.MultiThreading;

public class MonitoringLockHelper {

    public synchronized void task1(){
        // do something
        try {
            System.out.println(Thread.currentThread().getName() + " inside task1");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2(){
        System.out.println(Thread.currentThread().getName() + " task2, but before synchornized");
        synchronized (this){
            System.out.println("task2, inside synchronized");
        }
    }

    public void task3(){
        System.out.println(Thread.currentThread().getName() + " task3 completed");
    }
}
