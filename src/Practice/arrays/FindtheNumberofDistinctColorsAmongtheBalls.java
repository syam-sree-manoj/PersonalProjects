package Practice.arrays;

import java.util.*;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    // https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
    // https://www.youtube.com/watch?v=Gx-gGzz7S-s
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] ans = new int[n];
        int i = 0;

        Map<Integer,Integer> colorFreqMap = new HashMap<>();
        Map<Integer,Integer> ballColorMap = new HashMap<>();

        for(int[] query : queries){
            int ball = query[0];
            int color = query[1];

            int existingColorForBall = ballColorMap.getOrDefault(ball, -1);
            if(existingColorForBall == -1){
                // this ball is colored for first time
                ballColorMap.put(ball, color);
                colorFreqMap.compute(color, (key,val) -> {
                    if(val == null) return 1;
                    return ++val;
                });
            }else if( existingColorForBall == color){
                // painting the ball with same color
                // do nothing
            }else{
                // painting the ball with different color
                // dec freq of existing color by 1
                // inc freq of new color by 1
                ballColorMap.put(ball, color);
                colorFreqMap.compute(existingColorForBall, (key,val) -> {
                    if(val == 1) return null;
                    return --val;
                });
                colorFreqMap.compute(color, (key,val) -> {
                    if(val == null) return 1;
                    return ++val;
                });
            }
            ans[i] = colorFreqMap.size();
            i++;
        }
        return ans;
    }
}
