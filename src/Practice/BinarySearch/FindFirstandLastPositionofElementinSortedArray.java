package Practice.BinarySearch;

public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = binarySearch(nums, target, true);
        ans[1] = binarySearch(nums, target, false);

        return ans;
    }
    private int binarySearch(int[] nums, int target, boolean searchLeft){
        int n = nums.length;
        int left = 0;
        int right = n-1;
        int ans = -1;
        while(left <= right){
            int mid = (left+right)/2;
            if(nums[mid] < target){
                left = mid+1;
            }else if( target < nums[mid]){
                right = mid-1;
            }else{
                ans = mid;
                if(searchLeft){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return ans;
    }
}
