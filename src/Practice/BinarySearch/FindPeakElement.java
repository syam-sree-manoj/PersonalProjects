package Practice.BinarySearch;

public class FindPeakElement {
    // https://leetcode.com/problems/find-peak-element
    public int findPeakElement(int[] nums) {
        int minVal = Integer.MIN_VALUE;

        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-2] < nums[n-1]) return n-1;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = (left+right)/2;
            int midEle = nums[mid];
            int leftEle = (mid==0)? minVal : nums[mid-1];
            int rightEle = (mid == n-1) ? minVal : nums[mid+1];

            if( leftEle < midEle && midEle > rightEle){
                return mid;
            }else if( leftEle < midEle){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return -1;
    }
}
