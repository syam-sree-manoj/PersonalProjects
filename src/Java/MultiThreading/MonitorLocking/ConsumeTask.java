package Java.MultiThreading.MonitorLocking;

public class ConsumeTask implements Runnable{
    SharedResource sharedResource;
    ConsumeTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Consumer thread: " + Thread.currentThread().getName());
        sharedResource.consumeItem();
        System.out.println("Consumer thread completed: " + Thread.currentThread().getName());
    }
}
