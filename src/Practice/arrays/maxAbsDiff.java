package Practice.arrays;

import java.util.Scanner;
// https://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/
public class maxAbsDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements separated by comma:");

        String input = sc.nextLine();
        String[] parts = input.split(",");

        int[] arr = new int[parts.length];

        for(int i=0; i<parts.length; i++){
            arr[i] = Integer.parseInt(parts[i]);
        }

    }

    public static int maxAbsolutediff(int[] arr){
        int n = arr.length;

        int[] maxLeft = new int[n];
        maxLeftSubArraySum(arr,n,maxLeft);

        int[] maxRight = new int[n];
        maxRightSubArraySum(arr,n,maxRight);

        int[] invert = new int[n];
        for(int i=0; i<n; i++){
            invert[i] = -arr[i];
        }

        int[] minLeft = new int[n];
        maxLeftSubArraySum(invert,n,minLeft);
        for(int i=0; i<n; i++){
            minLeft[i] = -minLeft[i];
        }

        int[] minRight = new int[n];
        maxRightSubArraySum(invert,n,minRight);
        for(int i=0; i<n; i++){
            minRight[i] = -minRight[i];
        }

        int res = Integer.MIN_VALUE;

        for(int i=0; i<n-1; i++){
            int diff1 = Math.abs(maxLeft[i] - minRight[i+1]);
            int diff2 = Math.abs(maxRight[i+1] - minLeft[i]);

            res = Math.max(diff2, diff1);
        }

        return res;
    }

    public static void maxLeftSubArraySum(int[] arr, int n, int[] maxLeft){
        int maxSumSoFar = arr[0];
        int sum = arr[0];
        maxLeft[0] = maxSumSoFar;
        for(int i = 1; i<n; i++){
            // Find the maximum sum ending at index i by either extending
            // the maximum sum subarray ending at index i - 1 or by
            // starting a new subarray from index i
            if( arr[i] <= sum+arr[i]){
                // i should be part of contiguous subarray i.e if sum > 0
                sum += arr[i];
            }else{
                // adding previous sum to arr[i] is decreasing the value i.e prev sum<0
                // start new subarray with current index
                sum = arr[i];
            }
            maxSumSoFar = Math.max(maxSumSoFar, sum);
            maxLeft[i] = maxSumSoFar;
        }
    }

    public static void maxRightSubArraySum(int[] arr, int n, int[] maxRight){
        int maxSumSoFar = arr[n-1];
        int sum = arr[n-1];

        maxRight[n-1] = arr[n];

        for(int i=n-2; i>=0; i--){

            if(arr[i] < sum+arr[i]){
                sum += arr[i];
            }else{
                sum = arr[i];
            }

            maxSumSoFar = Math.max(maxSumSoFar, sum);
            maxRight[i] = maxSumSoFar;
        }
    }
}
