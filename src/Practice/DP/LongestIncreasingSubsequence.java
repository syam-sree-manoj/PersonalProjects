package Practice.DP;

public class LongestIncreasingSubsequence {
    // https://www.youtube.com/watch?v=IFfYfonAFGc ( iterative )
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n+1];

        return solve(nums,n,0,-1, memo);
    }

    public int lisIterative(int[] nums){
        int n = nums.length;
        Integer[][] memo = new Integer[n+1][n+1];

        for(int currIndex=n-1; currIndex>=0; currIndex--){
            for(int prevIndex = currIndex-1; prevIndex >= -1; prevIndex--){
                // can only take when curr ele is larger than prev ele
                int len = Integer.MIN_VALUE;
                if(prevIndex == -1 || nums[prevIndex] < nums[currIndex]){
                    // take curr element
                    int sub1 = 1 + memo[currIndex+1][prevIndex+1];
                    len = Math.max(sub1, len);
                }

                // dont take curr element
                int sub2 = memo[currIndex+1][prevIndex+1];

                len = Math.max(len, sub2);

                memo[currIndex][prevIndex+1] = len;
            }
        }

        return memo[0][-1+1];
    }
    public int solve(int[] nums, int n, int currIndex, int prevIndex, Integer[][] memo){
        if(currIndex >= n){
            // reached end of array
            return 0;
        }
        if( memo[currIndex][prevIndex+1] != null) return memo[currIndex][prevIndex+1];
        int ans = Integer.MIN_VALUE;

        // can only take when curr ele is larger than prev ele
        if(prevIndex == -1 || nums[prevIndex] < nums[currIndex]){
            // take curr element
            int sub1 = 1 + solve(nums, n, currIndex+1, currIndex, memo);;
            ans = Math.max(sub1, ans);
        }

        // dont take curr element
        int sub2 = solve(nums, n, currIndex+1, prevIndex, memo);

        ans = Math.max(ans, sub2);
        memo[currIndex][prevIndex+1] = ans;

        return ans;
    }
}
