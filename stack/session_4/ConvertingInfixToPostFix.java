package stack.session_4;

import java.util.ArrayDeque;

public class ConvertingInfixToPostFix {
    public static void main(String[] args) {

        String s = "a * ( d - e + f ) - g * h";
        String res = infixToPostfix(s);

        System.out.println(res);

    }
    static String infixToPostfix(String s){
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        String tokens[] = s.split(" ");

        for (String token: tokens){
            if(token.equals("(")){
                stack.push(token);
            }else if(isOperator(token)){
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)){
                    String temp = stack.pop();
                    sb.append(temp).append(" ");
                }
                stack.push(token);
            }else if(token.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    String temp = stack.pop();
                    sb.append(temp).append(" ");
                }
                stack.pop();
            }else{
                sb.append(token).append(" ");
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        return sb.toString();
    }

    static int precedence(String s){
        switch (s){
            case "^":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return -1;
        }
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
}
