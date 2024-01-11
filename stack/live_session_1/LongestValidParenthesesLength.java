package stack.live_session_1;

import java.util.ArrayDeque;

public class LongestValidParenthesesLength {
    public static void main(String[] args) {

        String s = "(()()(()";
        int res = longestValidParenthesesLength(s);

        System.out.println(res);

    }
    static int longestValidParenthesesLength(String s){
        int n = s.length();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int leftBoundary = -1;
        int length = 0;

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    leftBoundary = i;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        length = Math.max(length, i-leftBoundary);
                    }else{
                        length = Math.max(length, i-stack.peek());
                    }
//                    System.out.println(length);
                }
            }
        }
        return length;
    }
}
