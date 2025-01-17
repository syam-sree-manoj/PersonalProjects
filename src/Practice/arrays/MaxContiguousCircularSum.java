package Practice.arrays;

import java.util.Scanner;

// https://www.geeksforgeeks.org/maximum-contiguous-circular-sum/#expected-approach-using-kadanes-algorithm-on-time-and-o1-space
public class MaxContiguousCircularSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array elements separated by comma:");

        String input = sc.nextLine();
        String[] splits = input.split(";");

        int[] arr = new int[splits.length];
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(splits[i]);
        }
    }
    public static int maxCirularSubarrySum(int[] arr){
        int n = arr.length;
        int[] maxPrefixSum = new int[n];
        int[] minPrefixSum = new int[n];

        int maxSum = calculateMaxLeftSum(arr,maxPrefixSum);
        int minSum = calculateMinLeftSum(arr,minPrefixSum);

        int totalSum = 0;
        for(int num: arr){
            totalSum += num;
        }

        int maxCircularSum = totalSum - minSum;

        if(maxCircularSum == 0){
            return maxSum;
        }
        return Math.max(maxCircularSum, maxSum);
    }

    public static int calculateMaxLeftSum(int[] arr, int[] maxPrefixSum){
        int n=arr.length;
        int sumSoFar = arr[0];
        int maxSumSoFar = arr[0];
        maxPrefixSum[0] = arr[0];

        for(int i=1; i<n; i++){
//            sumSoFar = Math.max(arr[i], sumSoFar+arr[i]);
            if(arr[i] > sumSoFar+arr[i]){
                sumSoFar = arr[i];
            }else{
                sumSoFar += arr[i];
            }
            maxSumSoFar = Math.max(maxSumSoFar, sumSoFar);
            maxPrefixSum[i] = maxSumSoFar;
        }
        return maxSumSoFar;
    }

    public static int calculateMinLeftSum(int[] arr, int[] minPrefixSum){
        int n = arr.length;
        int sumSoFar = arr[0];
        int minSumSoFar = arr[0];
        minPrefixSum[0] = arr[0];

        for(int i=0; i<n; i++){
            if(arr[i] < sumSoFar+arr[i]){
                // dont take sumSoFar since sumSoFar > 0 and start new subarray at i
                sumSoFar = arr[i];
            }else{
                sumSoFar += arr[i];
            }
            minSumSoFar = Math.min(minSumSoFar, sumSoFar);
            minPrefixSum[i] = minSumSoFar;
        }
        return minSumSoFar;
    }
}
