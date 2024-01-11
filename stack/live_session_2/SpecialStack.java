package stack.live_session_2;

import java.util.ArrayDeque;

public class SpecialStack {

    ArrayDeque<Integer> stack;
    int min;

    public SpecialStack(){
        stack = new ArrayDeque<>();
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            min = x;
            return;
        }
        if(x < min){
            stack.push(2*x-min);
            min = x;
            return;
        }
        stack.push(x);
    }

    public int pop(){
        if(stack.isEmpty())return -1;
        int toPop = stack.pop();
        if(toPop < min){
            int temp = min;
            min = 2*min-toPop;
            return temp;
        }
        return toPop;
    }

    public int getMin(){
        if(stack.isEmpty())return -1;
        return min;
    }

}
