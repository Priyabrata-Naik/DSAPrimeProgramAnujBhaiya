package stack.session_5;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaximumOfMinimumWindowSize {
    public static void main(String[] args) {

        int a[] = {1, 4, 3, 2, 7, 9, 6, 4};
        int ans[] = maxOfMinWindowSizeOp(a);

        for(int e: ans){
            System.out.print(e+" ");
        }

    }
    static int[] maxOfMinWindowSizeOp(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        Arrays.fill(ans,Integer.MIN_VALUE);
        int left[] = smallerOnLeft(a);
        int right[] = smallerOnRight(a);

        for(int i = 0; i < n; i++){
//            Here, we are calculating windowLength
            int winLength = right[i]-left[i]-1;
            ans[winLength-1] = Math.max(a[i], ans[i]);
        }
        for(int i = n-2; i >= 0; i--){
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }
    static int[] smallerOnLeft(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
    static int[] smallerOnRight(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = n;
            }else{
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}
