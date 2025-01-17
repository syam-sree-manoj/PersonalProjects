package MultiThreading.ArriseQuestions.PrintSequence;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UsingReentrantLock {
    private static final int MAX = 30;
    private static int counter = 0;

    // ReentrantLock and Conditions for each thread
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition0 = lock.newCondition();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();

    public static void main(String[] args) {
        // Creating and starting threads
        Thread t0 = new Thread(new PrintTask(0, condition0, condition1));
        Thread t1 = new Thread(new PrintTask(1, condition1, condition2));
        Thread t2 = new Thread(new PrintTask(2, condition2, condition0));

        t0.start();
        t1.start();
        t2.start();
    }

    static class PrintTask implements Runnable {
        private final int threadId;
        private final Condition myCondition;
        private final Condition nextCondition;

        public PrintTask(int threadId, Condition myCondition, Condition nextCondition) {
            this.threadId = threadId;
            this.myCondition = myCondition;
            this.nextCondition = nextCondition;
        }

        @Override
        public void run() {
            while (counter <= MAX) {
                lock.lock();  // Acquire the lock
                try {
                    if (counter % 3 == threadId) {
                        System.out.println("T" + threadId + " printing " + counter);
                        counter++;
                    }
                    // Signal the next thread
                    nextCondition.signal();
                    // Wait for the signal to continue
                    if (counter < MAX) {
                        myCondition.await();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    System.out.println(Thread.currentThread().getName());
                    lock.unlock();  // Release the lock
                }
            }
        }
    }
}
