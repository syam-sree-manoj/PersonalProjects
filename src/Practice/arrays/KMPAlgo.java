package Practice.arrays;
import java.util.*;
// https://leetcode.com/problems/string-matching-in-an-array/
// ** very well explained Knuth–Morris–Pratt KMP - https://www.youtube.com/watch?v=JoF0Z7nVSrA
public class KMPAlgo {
    public List<String> stringMatching(String[] words) {
        List<String> ans = new ArrayList<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isPatternInString(words[j], words[i])) {
                    ans.add(words[i]);
                    break; // No need to check further for this word
                }
            }
        }
        return ans;
    }

    // Function to check if pattern is a substring of text using KMP
    public boolean isPatternInString(String text, String pattern) {
        int[] lps = calculateLPSUsingKMP(pattern);
        int i = 0, j = 0, n = text.length();

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = lps[j - 1];
            }

            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }

    // Function to calculate LPS array for KMP algorithm
    public int[] calculateLPSUsingKMP(String word) {
        int n = word.length();
        int[] lps = new int[n];
        int i = 1, j = 0;

        while (i < n) {
            if (word.charAt(i) == word.charAt(j)) {
                // AAA
                lps[i] = j + 1;
                i++;
                j++;
            } else if (j == 0) {
                // AB
                lps[i] = 0;
                i++;
            } else {
                j = lps[j - 1];
            }
        }
        return lps;
    }
}

