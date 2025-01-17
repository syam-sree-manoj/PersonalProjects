package MultiThreading.ArriseQuestions.PrintSequence;

class UsingSynchronized implements Runnable {
    private static final int MAX_NUMBER = 30;
    private static int number = 0; // Shared counter
    private final int threadId; // Thread ID (T0, T1, T2)
    private final int totalThreads; // Total number of threads
    private final Object lock; // Shared lock object

    public UsingSynchronized(int threadId, int totalThreads, Object lock) {
        this.threadId = threadId;
        this.totalThreads = totalThreads;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) { // Synchronize on the shared lock object
                // Wait until it's this thread's turn
                while (number % totalThreads != threadId) {
                    try {
                        lock.wait(); // Wait for the signal to proceed
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                // Stop if the maximum number is reached
                if (number > MAX_NUMBER) {
                    lock.notifyAll(); // Notify all threads to terminate
                    break;
                }

                // Print the number
                System.out.println("T" + threadId + " printing " + number);
                number++; // Increment the shared counter

                // Notify the next thread
                lock.notify(); // Notify the next thread (not all threads)
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object(); // Shared lock object
        int totalThreads = 3; // Number of threads

        // Create and start threads
        Thread t0 = new Thread(new UsingSynchronized(0, totalThreads, lock));
        Thread t1 = new Thread(new UsingSynchronized(1, totalThreads, lock));
        Thread t2 = new Thread(new UsingSynchronized(2, totalThreads, lock));

        t0.start();
        t1.start();
        t2.start();
    }
}
