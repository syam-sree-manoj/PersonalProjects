package Practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class TuplewithSameProduct {
    // https://leetcode.com/problems/tuple-with-same-product/
    // https://www.youtube.com/watch?v=SSwvMoOhiq0
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;

        HashMap<Integer, Integer> productCountMap = new HashMap<>();
        /*
        p1 p2 p3 are pairs having same product
        so total 6 combinations to fill 2 spots
         */
        HashMap<Integer, Integer> pairCombinationsCountMap = new HashMap<>();

        /*
        to calculate pair count : add productCount to existing pair count
         */

        for(int i=0; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                int product = nums[i] * nums[j];
                pairCombinationsCountMap.compute(product, (key,val) -> (val == null) ? 0 : val + productCountMap.getOrDefault(key,0));
                productCountMap.compute(product, (key,val) -> (val == null) ? 1 : val+1);

            }
        }

        int tuples = 0;
        for(Map.Entry<Integer,Integer> entry : pairCombinationsCountMap.entrySet()){
            tuples += entry.getValue() * 8;
        }

        return tuples;
    }

    public int tupleSameProductApproach(int[] nums){
        int n = nums.length;
        HashMap<Integer, Integer> productCountMap = new HashMap<>();
        for(int i=0; i<n-1; i++){
            for(int j= i+1; j<n; j++){
                int product = nums[i] * nums[j];
                productCountMap.compute(product, (key,val) -> (val == null) ? 1 : val+1);
            }
        }
        int tuples = 0;
        for(Map.Entry<Integer,Integer> entry : productCountMap.entrySet()){
            int val = entry.getValue();
            tuples += (val * (val-1))/2;
        }

        return tuples;
    }
}
