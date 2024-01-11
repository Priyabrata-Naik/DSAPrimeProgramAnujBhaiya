package stack.session_3;

import java.util.ArrayDeque;

public class EvaluatingPostfixExp {
    public static void main(String[] args) {

        String s = "22 3 4 - 2 * +";
        int res = evaluatePostfixOp(s);

        System.out.println(res);

    }
    static int evaluatePostfixOp(String s){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String tokens[] = s.split(" ");

        for(String token: tokens){
            if(isOperator(token)){
                int second = stack.pop();
                int first = stack.pop();
                int result = 0;

                switch (token){
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first/second;
                        break;
                    case "^":
                        result = (int) Math.pow(first,second);
                        break;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }
}
