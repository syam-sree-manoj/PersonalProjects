package MultiThreading.MonitorLocking;

public class ProduceTask implements  Runnable{
    SharedResource sharedResource;
    ProduceTask(SharedResource sharedResource){
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer Thread : " + Thread.currentThread().getName());
        try {
            // wait added because to make sure consumer thread is executed first
            Thread.sleep(5000l);
        }catch (Exception e){

        }
        sharedResource.addItem();
    }
}
