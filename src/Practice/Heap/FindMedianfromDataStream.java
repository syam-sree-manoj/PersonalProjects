package Practice.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    // https://leetcode.com/problems/find-median-from-data-stream/
    // https://www.youtube.com/watch?v=itmhHWaHupI
    /*
    arr = [ 3, 2, 7, 4 ]
     */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public FindMedianfromDataStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        // maxHeap contains left sorted elements
        // minHeap contains right sorted elements

        maxHeap.offer(num);

        // make sure left elements are sorted ie present in maxHeap and
        // all elements in maxHeap should be less than elements in minHeap
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            int maxHeapIt = maxHeap.poll();
            minHeap.offer(maxHeapIt);
        }

        // balance heaps
        if(maxHeap.size() > minHeap.size()+1){
            int maxHeapIt = maxHeap.poll();
            minHeap.offer(maxHeapIt);
        }
        if(minHeap.size() > maxHeap.size()+1){
            int minHeapIt = minHeap.poll();
            maxHeap.offer(minHeapIt);
        }

    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else if(maxHeap.size() < minHeap.size()){
            return minHeap.peek();
        }else{
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }
}
