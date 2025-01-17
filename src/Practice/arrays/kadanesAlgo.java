package Practice.arrays;

import java.util.Scanner;
// https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/#expected-approach-using-kadanes-algorithm-on-time-and-o1-space
// https://www.youtube.com/watch?v=AHZpyENo7k4
public class kadanesAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements separated by comma:");

        String input = sc.nextLine();
        String[] splits = input.split(",");
        int[] arr = new int[splits.length];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(splits[i]);
        }

        int maxSumSubarray = kadaneAlgo(arr);

        if(maxSumSubarray < 0){
            // best is to not take any element
            System.out.println("0");
        }

        System.out.println(maxSumSubarray);
    }

    public static int kadaneAlgo(int[] arr){
        int n = arr.length;

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int ansStart = -1, ansEnd = -1, start = -1;

        for(int i=0; i<n; i++){
            if(arr[i] < sum+arr[i]){
                // i should be part of contiguous subarry
                sum += arr[i];
            }else{
                // i.e sum < 0 hence dont take previous sum therefore start new subarray at i.
                sum = arr[i];
                start = i;
            }
            if( sum > maxSum){
                ansStart = start;
                ansEnd =  i;
                maxSum = sum;
            }
        }

        return maxSum;
    }
}
