package Practice.arrays;

import java.util.*;

public class CountNumberofBadPairs {
    // https://leetcode.com/problems/count-number-of-bad-pairs/
    // https://www.youtube.com/watch?v=h13Y9sDbQ6w
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> numIndexDiffMap = new HashMap<>();
        int totalPairs = 0;
        int totalGoodPairs = 0;

        for(int i=0; i<n; i++){
            totalPairs += i;
            int currGoodPairs = numIndexDiffMap.getOrDefault(nums[i]-i , 0);
            totalGoodPairs += currGoodPairs;
            numIndexDiffMap.put(nums[i]-i , currGoodPairs+1);
        }
        return totalPairs-totalGoodPairs;
    }
}
