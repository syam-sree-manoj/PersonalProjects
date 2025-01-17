package MultiThreading.ProducerConsumerProblem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SharedResource {

    private Deque<Integer> sharedResource;
    private int size;

    SharedResource(int size){
        this.sharedResource = new ArrayDeque<>();
        this.size = size;
    }

    public synchronized void addItem(Integer item){
        while(sharedResource.size() >= size){
            try {
                System.out.println(Thread.currentThread().getName() + " : is waiting bcoz queue is full, while adding item");
                wait(); // releases all monitor locks
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        sharedResource.addLast(item);
        System.out.println("added item : " + sharedResource.peekLast());
        notify();
    }

    public synchronized void consumeItem(){
        while(sharedResource.isEmpty()){
            try {
                System.out.println(Thread.currentThread().getName() + " : is waiting bcoz queue is empty, while consuming element");
                wait(); // releases all monitor locks
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int item = sharedResource.pollFirst();
        System.out.println("consumed : " + item);
        notify();
    }
}
