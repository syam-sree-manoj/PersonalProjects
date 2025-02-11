package Practice.Stack;

import java.util.Stack;

public class RemoveAllOccurrencesofaSubstring {
    // https://leetcode.com/problems/remove-all-occurrences-of-a-substring
    public String removeOccurrences(String s, String part) {
        int sLen = s.length();
        int partLen = part.length();

        if( sLen < partLen) return s;
        if( sLen == partLen && s.equals(part)) return "";

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<sLen; i++){
            stack.push(s.charAt(i));
            if(stack.size() >= partLen && checkIfStackTopEqualsPart(stack,part)){
                for (int j = 0; j < partLen; j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private boolean checkIfStackTopEqualsPart(Stack<Character> stack, String part){
        int partLen = part.length();
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);

        for(int i=partLen-1; i>=0; i--){
            if(temp.peek() != part.charAt(i)) return false;
            temp.pop();
        }
        return true;
    }
}
