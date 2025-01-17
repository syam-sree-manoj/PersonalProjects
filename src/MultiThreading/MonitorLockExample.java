package MultiThreading;

public class MonitorLockExample {
    // https://www.udemy.com/course/both-java-springboot-basics-to-advanced/learn/lecture/46410629#overview

    public static void main(String[] args) {

        MonitoringLockHelper obj = new MonitoringLockHelper();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                obj.task1();
            }
        };

        Thread t0 = new Thread(runnable);

        Thread t1 = new Thread(() -> {obj.task2();});

        Thread t2 = new Thread(() -> {obj.task3();});

        t0.start();
        t1.start();
        t2.start();

    }
}
