package Practice.BinarySearch;

public class SearchinRotatedSortedArrayII {
    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii
    // https://www.youtube.com/watch?v=w2G2W8l__pc
    /*
    arr = [ 3 1 2 3 3 3 3 ]
    for this array you can not eliminate left half or right half
    So trim down the array
     */
    public boolean search(int[] nums, int target) {
        int n = nums.length;

        int left = 0;
        int right = n-1;
        // find pivot index
        while(left <= right){
            int mid = (left+right)/2;
            int midEle = nums[mid];
            if(midEle == target){
                return true;
            }
            if( nums[left] == midEle && midEle == nums[right] ){
                // trim down the search space
                left++;
                right--;
            }else if(nums[left] <= midEle){
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
        return false;
    }
}
