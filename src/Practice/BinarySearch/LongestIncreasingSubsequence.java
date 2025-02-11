package Practice.BinarySearch;

import java.util.*;

public class LongestIncreasingSubsequence {
    // https://leetcode.com/problems/longest-increasing-subsequence/
    // https://www.youtube.com/watch?v=on2hvxBXJH4

    public int lengthOfLIS(int[] arr) {
        List<Integer> lis = new ArrayList<>();
        lis.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            if(lis.get(lis.size()-1) < arr[i]){
                lis.add(arr[i]);
            }else{
                int insertionIndex = getInsertionIndex(lis, arr[i]);
                // int insertionIndex = Collections.binarySearch(lis, arr[i]);
                lis.set(insertionIndex, arr[i]);
            }
        }
        return lis.size();
    }
    public int getInsertionIndex(List<Integer> list, int target){

        int high = list.size()-1;
        int low = 0;

        while(low <= high){
            int mid = (low+high) >> 1;
            if(list.get(mid) == target){
                high = mid-1;
            }
            else if(list.get(mid) < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

}
