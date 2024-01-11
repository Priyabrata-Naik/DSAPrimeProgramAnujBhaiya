package stack.session_2;

import java.util.ArrayDeque;

public class ParenthesisMatching {
    public static void main(String[] args) {

        String s = "}(){}[]";

        boolean res = validParenthesisOp(s);

        System.out.println(res);

    }
    static boolean validParenthesisOp(String s){
        int n = s.length();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                char opening = stack.pop();
                if((opening == '(' && c == ')') || (opening == '{' && c == '}') || (opening == '[' && c == ']')){
                    continue;
                }else
                    return false;
            }
        }
        return stack.isEmpty();
    }
    static boolean parenthesisMatchingByMe(String s){

        int n = s.length();

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(c == ')'){
                if(stack.peek() == '('){
                    stack.poll();
                }else{
                    return false;
                }
            }else if(c == '}'){
                if(stack.peek() == '{'){
                    stack.poll();
                }else{
                    return false;
                }
            }else if(c == ']'){
                if(stack.peek() == '['){
                    stack.poll();
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
