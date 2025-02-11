package Practice.DP;

import java.util.*;

public class WordBreak {
    // https://leetcode.com/problems/word-break/
    // https://www.youtube.com/watch?v=Sx9NNgInc3A
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        return solve(s, wordDict, 0, n, new Boolean[n]);
    }

    public boolean solve(String s, List<String> wordDict, int currIndex, int n, Boolean[] memo){

        if(currIndex >= n){
            return true;
        }
        if(memo[currIndex] != null) return memo[currIndex];
        Boolean ans = false;

        for(int i=0; i<wordDict.size(); i++){
            String word = wordDict.get(i);
            int subStringEndIndex = currIndex + word.length();
            if(subStringEndIndex <= n && word.equals(s.substring(currIndex, subStringEndIndex))){
                Boolean sub = solve(s,wordDict, subStringEndIndex, n, memo);
                if( sub == true){
                    ans = true;
                    break;
                }
            }
        }
        memo[currIndex] = ans;
        return ans;
    }
}
