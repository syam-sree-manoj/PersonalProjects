package Practice.BinarySearch;

public class FindMinimuminRotatedSortedArray {
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
    // https://www.youtube.com/watch?v=nhEMDKMB44g
    /*
    arr = [ 4 5 1 2 3 ]
    for this array you cannot straight away eliminate right half and make right = mid-1
    so tack the min before eliminating the right half
     */
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[left] <= nums[right]){
                // search space is already sorted
                min = Math.min(min, nums[left]);
                return min;
            }
            if(nums[left] <= nums[mid]){
                // left is sorted
                min = Math.min(min, nums[left]);
                left = mid+1;
            }else{
                // right is sorted
                min = Math.min(min, nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }
}
