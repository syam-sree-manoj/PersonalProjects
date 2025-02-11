package Practice.Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    // https://leetcode.com/problems/kth-largest-element-in-an-array
    // https://www.youtube.com/watch?v=XEmy13g1Qxc using quick select
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            if(minpq.size() < k){
                minpq.offer(nums[i]);
                continue;
            }
            if(!minpq.isEmpty() && nums[i] > minpq.peek()){
                minpq.poll();
                minpq.offer(nums[i]);
            }
        }
        return minpq.poll();
    }
}
