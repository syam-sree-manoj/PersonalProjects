package Java.MultiThreading.ProducerConsumerProblem;

public class Main {
    // https://www.udemy.com/course/both-java-springboot-basics-to-advanced/learn/lecture/46410635#overview

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource(3);

        Runnable runnableProducer = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(int i=0; i<=6; i++){
                    sharedResource.addItem(i);
                }
            }
        };

        Runnable runnableConsumer = new Runnable() {
            @Override
            public void run() {
                for(int i=0; i<=6; i++){
                    sharedResource.consumeItem();
                }
            }
        };

        Thread producerThread = new Thread(runnableProducer, "producerThread");
        Thread consumerThread = new Thread(runnableConsumer, "consumerThread");

        producerThread.start();
        consumerThread.start();
    }
}
