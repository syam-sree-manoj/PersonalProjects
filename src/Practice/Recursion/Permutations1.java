package Practice.Recursion;

import java.util.*;

public class Permutations1 {
    // https://leetcode.com/problems/permutations/description/
    // https://www.youtube.com/watch?v=f2ic2Rsc9pU
    // Array holds distinct integers

    //Using swap technique
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        solve(res, nums, new ArrayList<>(), 0);


        return res;
    }

    // we are filling index place of currPermutation
    private List<List<Integer>> solve(List<List<Integer>> res, int[] nums, List<Integer> currPermutation, int index){
        if(currPermutation.size() == nums.length){
            List<Integer> sub = new ArrayList<>(currPermutation);
            res.add(sub);
            return res;
        }

        for(int i=index; i<nums.length; i++){
            currPermutation.add(nums[i]);
            swap(nums, index, i);

            solve(res,nums, currPermutation, index+1);

            currPermutation.remove(currPermutation.size()-1);
            swap(nums, index, i);
        }

        return res;
    }

    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

}
