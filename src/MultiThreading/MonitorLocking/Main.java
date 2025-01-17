package MultiThreading.MonitorLocking;

public class Main {
    // https://www.udemy.com/course/both-java-springboot-basics-to-advanced/learn/lecture/46410629#overview

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        System.out.println("Main method end");

        Thread producerThread = new Thread(new ProduceTask(sharedResource));
        Thread consumerThread = new Thread(new ConsumeTask(sharedResource));

        producerThread.start();
        consumerThread.start();

        System.out.println("Main method end");
    }
}
