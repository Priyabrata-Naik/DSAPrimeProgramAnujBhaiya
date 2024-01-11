package stack.live_session_2;

import java.util.ArrayDeque;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {

        int a[] = {2, 1, 5, 6, 2, 3};
        int res = maxAreaInHistogram(a);

        System.out.println(res);

    }
    static int maxAreaInHistogram(int a[]){
        int n = a.length;
        int prevSmall[] = smallOnLeft(a);
        int nextSmall[] = smallOnRight(a);
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            int curArea = (nextSmall[i]-prevSmall[i]-1)*a[i];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
    static int[] smallOnLeft(int a[]){
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
    static int[] smallOnRight(int a[]){
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
