package Practice.arrays;

import java.util.Arrays;

public class NextPermutation {
    // https://leetcode.com/problems/next-permutation/description/
    // https://www.youtube.com/watch?v=JDOXKqF60RQ

    /*
        Step-1 : find longest prefix match
        Step-2 : iterate from right to find next greater element and swap with it
        step-3 : then reverse the array from i+1 to n-1 since after swaping it maintains descending order
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int index = findLongestPrefix(nums);

        if( index == -1){
            // we found longest permutation
            // so reverse the array and return
            reverse(nums, index+1);
            return;
        }
        System.out.println(Arrays.toString(nums));
        swap(nums, index);
        reverse(nums, index+1);
    }

    private void swap(int[] nums, int index){
        int n = nums.length;

        for(int i=n-1; i>=index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                return;
            }
        }
    }

    private int findLongestPrefix(int[] nums){
        int n = nums.length;
        int index = -1;
        // longest prefix match
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        return index;
    }

    private void reverse(int[] nums, int index){
        int start=index, end=nums.length-1;
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }

}
