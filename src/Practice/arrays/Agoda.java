package Practice.arrays;
import java.util.*;
public class Agoda {
    public static int getMinimumTime(List<Integer> processSize, List<Integer> capacity) {
        // Sort process sizes in descending order to prioritize larger tasks first
        Collections.sort(processSize, Collections.reverseOrder());
        // Sort processor capacities in descending order
        Collections.sort(capacity, Collections.reverseOrder());

        // If the largest process cannot be handled by the largest processor, return -1
        if (processSize.get(0) > capacity.get(0)) {
            return -1;
        }

        // priorityQueue of capacity
        PriorityQueue<Integer> processorQueue = new PriorityQueue<>( (a,b) -> {
           if(a > b){
               return -1;
           }else{
               return 1;
           }
        });
        // Initialize all processors with availability time 0
        for (int cap : capacity) {
            processorQueue.offer(cap); // All processors are initially available at time 0
        }
        int time = 0;
        int index = 0;


        while(index < processSize.size()){
            int size = processorQueue.size();
            while(size > 0){

            }
            Integer nextAvailableProcessorCapacity = processorQueue.poll();

            if(nextAvailableProcessorCapacity < processSize.get(index)){
                processorQueue.offer(nextAvailableProcessorCapacity);
                time++;
            }else{
                processorQueue.offer(nextAvailableProcessorCapacity);
                time++;
                index++;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        // Test case 1
        List<Integer> processSize1 = Arrays.asList(1, 2, 3, 4, 6);
        List<Integer> capacity1 = Arrays.asList(4, 7, 4);
        System.out.println(getMinimumTime(processSize1, capacity1)); // Expected Output: 3

        // Test case 2
        List<Integer> processSize2 = Arrays.asList(2, 5, 8);
        List<Integer> capacity2 = Arrays.asList(6, 7, 4);
        System.out.println(getMinimumTime(processSize2, capacity2)); // Expected Output: -1
    }
}


