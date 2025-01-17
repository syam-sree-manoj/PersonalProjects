package MultiThreading.MonitorLocking;

public class SharedResource {
    boolean itemAvailable = false;

    public synchronized void addItem(){
        itemAvailable = true;
        System.out.println("item added by: " + Thread.currentThread().getName() + " invoking all threads which are waiting by notifyAll()");
        notifyAll();
    }

    public synchronized void consumeItem(){
        System.out.println("Consume item invoked by " + Thread.currentThread().getName());

        // using while loop to avoid spurious wake-up, sometimes due to system noise
        while(!itemAvailable){
            try {
                System.out.println("Thread :" + Thread.currentThread().getName() + " is waiting now");
                wait(); // it releases monitor locks
            }catch (Exception e){
                // handle
            }
        }

        System.out.println("item consumed by : " + Thread.currentThread().getName());
        itemAvailable = false;
    }
}
