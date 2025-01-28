package Java.MultiThreading;

public class ExtendingThread extends Thread{

    ExtendingThread(String name){
        super(name);
    }
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            try {
                System.out.println(Thread.currentThread().getName() + "- Priority: " + Thread.currentThread().getPriority());
                Thread.sleep(2000);
                Thread.yield();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}