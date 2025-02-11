package Practice.Strings;

import java.util.Stack;

public class RemoveAllOccurrencesofaSubstring {
    // https://leetcode.com/problems/remove-all-occurrences-of-a-substring
    // https://www.youtube.com/watch?v=JoF0Z7nVSrA


    public String removeOccurrences(String s, String part) {
        // Precompute KMP longest prefix-suffix array for the pattern
        int[] kmpLPS = findLongestPrefixSuffix(part);

        int strLen = s.length();
        int partLen = part.length();

        // Using stack to track characters and support pattern matching
        Stack<Character> charStack = new Stack<>();

        // Array to store pattern matching indices during traversal
        int[] patternIndexes = new int[s.length() + 1];

        /*
            s = "daabcbaabcbc", part = "abc"
        */

        for (int strIndex = 0, patternIndex = 0; strIndex < s.length(); strIndex++) {
            char currentChar = s.charAt(strIndex);
            charStack.push(currentChar);

            if (currentChar == part.charAt(patternIndex)) {
                // Track the next pattern index when characters match
                patternIndexes[charStack.size()] = ++patternIndex;

                if (patternIndex == part.length()) {
                    // Remove entire matched pattern from stack
                    for(int i=0; i<partLen; i++){
                        charStack.pop();
                    }
                    // Restore pattern index for next potential match
                    patternIndex = charStack.isEmpty() ? 0 : patternIndexes[charStack.size()];
                }
            } else {
                if (patternIndex != 0) {
                    // Backtrack pattern matching using KMP LPS
                    strIndex--;
                    patternIndex = kmpLPS[patternIndex - 1];
                    charStack.pop();
                } else {
                    // Reset pattern index tracking when no match is possible
                    patternIndexes[charStack.size()] = 0;
                }
            }
        }

        // Convert remaining stack characters to result string
        StringBuilder result = new StringBuilder();
        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }

        return result.reverse().toString();
    }

    private int[] findLongestPrefixSuffix(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];

        int prevLPSptr = 0;
        int i = 1;

        while( i < n){
            if(pattern.charAt(prevLPSptr) == pattern.charAt(i)){
                lps[i] = lps[prevLPSptr] + 1;
                i++;
                prevLPSptr++;
            }else{
                if( prevLPSptr == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    prevLPSptr = lps[prevLPSptr-1];
                }
            }
        }
        return lps;
    }
}
