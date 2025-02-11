package Practice.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.*;

public class LexicographicallySmallestArraybySwappingElements {
    // https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/
    // https://www.youtube.com/watch?v=-FGl6dzPexY
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);

        Map<Integer,Integer> numToGroupMap = new HashMap<>();
        Map<Integer, Deque<Integer>>  groupToNumsMap = new HashMap<>();

        int currentGroup = 0;
        groupToNumsMap.computeIfAbsent(currentGroup, key -> new ArrayDeque<>()).addLast(newNums[0]);
        numToGroupMap.put(newNums[0], currentGroup);

        for(int i=1; i<n; i++){
            if(newNums[i] - newNums[i-1] > limit){
                currentGroup++;
            }
            groupToNumsMap.computeIfAbsent(currentGroup, key -> new ArrayDeque<>()).addLast(newNums[i]);
            numToGroupMap.put(newNums[i], currentGroup);
        }

        for(int i=0; i<n; i++){
            int group = numToGroupMap.get(nums[i]);
            int presentMinFromGroup = groupToNumsMap.get(group).pollFirst();
            newNums[i] = presentMinFromGroup;
        }

        return newNums;
    }
}
