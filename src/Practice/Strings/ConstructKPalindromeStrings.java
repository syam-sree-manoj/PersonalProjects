package Practice.Strings;

import java.util.*;

public class ConstructKPalindromeStrings {
    // https://leetcode.com/problems/construct-k-palindrome-strings/
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        Map<Character,Integer> map = calculateFreq(s);
        int odd = 0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 1){
                odd++;
            }
        }

        if(odd <= k){
            return true;
        }
        return false;
    }

    Map<Character,Integer> calculateFreq(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.compute(c , (key,val) -> (val==null) ? 1 : val+1);
        }
        return map;
    }
}
