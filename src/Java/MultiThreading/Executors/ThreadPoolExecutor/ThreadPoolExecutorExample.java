package Java.MultiThreading.Executors.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

    public static void main(String[] args) {
        // Create a ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                4,
                5,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
                new CustomRejectedExecutionHandler()
        );

        // List to store Futures
        List<Future<String>> futures = new ArrayList<>();

        // Submit tasks to threadPoolExecutor and store their Future objects
        for (int i = 0; i < 10; i++) {
            int taskId = i;
            Future<String> future = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000); // Simulating a long-running task
                    String message = "Thread name: " + Thread.currentThread().getName() + " - Task ID: " + taskId + " completed.";
                    System.out.println(message);
                    return message;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            futures.add(future);
        }

        threadPoolExecutor.shutdown(); // Initiates shutdown
        try {
            if (!threadPoolExecutor.awaitTermination(10, TimeUnit.MINUTES)) {
                System.out.println("Forcing shutdown...");
                threadPoolExecutor.shutdownNow(); // Forcefully terminates tasks
            }
        } catch (InterruptedException e) {
            System.err.println("Shutdown interrupted. Forcing shutdown...");
            threadPoolExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }


        // Allow user to fetch results as needed
        System.out.println("Fetching results of all tasks:");
        for (int i = 0; i < futures.size(); i++) {
            try {
                Future<String> future = futures.get(i);
                String result = future.get(); // Blocking call to get the result
                System.out.println("Result of Task " + i + ": " + result);
            } catch (InterruptedException | ExecutionException e) {
                System.err.println("Error while fetching result for Task " + i + ": " + e.getMessage());
            }
        }


    }
}

class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setPriority(Thread.NORM_PRIORITY);
        return th;
    }
}

class CustomRejectedExecutionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task denied: " + r.toString());
    }
}
