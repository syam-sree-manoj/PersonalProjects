package Java.MultiThreading;

// https://www.youtube.com/watch?v=4aYvLz4E1Ts&t=11654s
public class MultiThreadingMain {
/*
    NEW,
    RUNNABLE,
    BLOCKED,
    WAITING,
    TIMED_WAITING,
    TERMINATED;
*/
    public static void main(String[] args) throws InterruptedException {
        ExtendingThread extendingThread1 = new ExtendingThread("syamThread");
        ExtendingThread extendingThread2 = new ExtendingThread("vijayaThread");
        ExtendingThread extendingThread3 = new ExtendingThread("ganapatiThread");
        System.out.println(extendingThread1.getState());
        extendingThread1.start();
        Thread.sleep(10000);
//        extendingThread2.start();
//        extendingThread3.start();
        System.out.println(extendingThread1.getState());
        extendingThread1.join();
        System.out.println(extendingThread1.getState());

        Runnable runnable = new WithRunnable();
        Thread t = new Thread(runnable, "RunnableThread");
        t.start();

        Runnable run = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<3; i++){
                    System.out.println("funtional interface");
                }
            }
        };

        Thread t2 = new Thread(run, "FuntionalInterfaceThread");
        t2.start();
    }

}
