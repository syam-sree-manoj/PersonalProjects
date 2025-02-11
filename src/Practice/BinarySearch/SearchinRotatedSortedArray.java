package Practice.BinarySearch;

public class SearchinRotatedSortedArray {
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // https://www.youtube.com/watch?v=5qGrJbHhqFs
    public int search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n-1;
        // find pivot index
        while(left <= right){
            int mid = (left+right)/2;
            int midEle = nums[mid];
            if(midEle == target){
                return mid;
            }if(nums[left] <= midEle){
                // left half is sorted
                if(nums[left] <= target && target < midEle){
                    // target lies in left half
                    right = mid-1;
                }else{
                    // target lies in right half
                    left = mid+1;
                }
            }else{
                // right half is sorted
                if( nums[mid] < target && target <= nums[right]){
                    // target lies in right half
                    left = mid+1;
                }else{
                    // target lies in left half
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}
