package stack.session_2;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class StockSpanProblem {
    public static void main(String[] args) {

        int price[] = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> ans = stockSpan(price);
        int res[] = stockSpanOp(price);

        for(int e: res){
            System.out.print( e+" ");
        }
        System.out.println();

        System.out.println(ans);

    }
//    O(n^2)
    static ArrayList<Integer> stockSpan(int price[]){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = price.length;

        for(int i = 0; i < n; i++){
            int j = i-1;
            while(j > 0 && price[j] <= price[i]){
                j--;
            }
            if(ans.isEmpty()){
                ans.add(1);
            }else{
                ans.add(i-j);
            }
        }
        return ans;
    }
    static int[] stockSpanOp(int a[]){
        int n = a.length;
        int s[] = new int[n];
        s[0] = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for(int i = 1; i < n; i++){
            while(!stack.isEmpty()){
                int top = stack.peek();
                if(a[top] > a[i]){
                    break;
                }else{
                    stack.pop();
                }
            }
            if((stack.isEmpty())){
                s[i] = i + 1;
            }else{
                s[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return s;
    }
}
