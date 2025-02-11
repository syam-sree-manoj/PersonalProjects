package Practice.Strings;

public class CheckifaParenthesesStringCanBeValid {
    // https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if(n % 2 == 1) return false;

        int leftOpen=0, leftClosed=0, rightOpen = 0, rightClosed=0;
        char[] sChars = s.toCharArray();
        char[] lockedChars = locked.toCharArray();
        int leftIndex, rightIndex;
        int leftWildCards = 0, rightWildCards =0;

        for(int i=0; i<n; i++){

            leftIndex = i;
            rightIndex = n-i-1;

            if(lockedChars[leftIndex] == '0'){
                leftWildCards++;
            }else if(sChars[leftIndex] == '('){
                leftOpen++;
            } else if(sChars[leftIndex] == ')'){
                leftClosed++;
            }

            if(lockedChars[rightIndex] == '0'){
                rightWildCards++;
            }else if(sChars[rightIndex] == '('){
                rightOpen++;
            } else if(sChars[rightIndex] == ')'){
                rightClosed++;
            }

            if(leftClosed - leftOpen > leftWildCards){
                return false;
            }

            if( rightOpen - rightClosed > rightWildCards){
                return false;
            }
        }

        return true;
    }
}
