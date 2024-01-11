package stack.session_5.task;

import java.util.ArrayDeque;

public class LargerElementOnBothSide {
    public static void main(String[] args) {

        int a[] = {1, 6, 4, 10, 2, 4};
        int leftLarger[] = largerOnLeft(a);
        int rightLarger[] = largerOnRight(a);

        printArray(leftLarger);
        printArray(rightLarger);
    }
    static void printArray(int a[]){
        for(int e: a){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static int[] largerOnLeft(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && a[stack.peek()] <= a[i]){
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
    static int[] largerOnRight(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && a[stack.peek()] <= a[i]){
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
