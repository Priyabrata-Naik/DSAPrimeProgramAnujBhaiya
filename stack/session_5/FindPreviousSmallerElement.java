package stack.session_5;

import java.util.ArrayDeque;

public class FindPreviousSmallerElement {
    public static void main(String[] args) {

        int a[] = {1, 6, 4, 10, 2, 4};
        int res[] = smallerOnRightOp(a);

        for(int e: res){
            System.out.print(e+" ");
        }
        System.out.println();

    }
    static int[] findSmallerElement(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ans[0] = -1;

        for(int i = 1; i < n; i++){
            int  j = i-1;
            if(a[i] > a[j]){
                ans[i] = j;
                continue;
            }
            while(j >= 0 && a[i] < a[j]){
                j--;
            }
            if(j < 0){
                ans[i] = -1;
            }else{
                ans[i] = j;
            }
        }
        return ans;
    }
    static int[] findSmallerElementStoreIndex(int a[]){
        int n = a.length;
        int ans[] = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        ans[0] = -1;

        for(int i = 1; i < n; i++){
            if(!stack.isEmpty() && a[i] > a[stack.peek()]){
                ans[i] = stack.peek();
                stack.push(i);
                continue;
            }
            while(!stack.isEmpty() && a[i] < a[stack.peek()]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek();
                stack.push(i);
            }else{
                ans[i] = -1;
                stack.push(i);
            }
        }
        return ans;
    }
    static int[] smallerOnLeftOp(int a[]){
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
    static int[] smallerOnRightOp(int a[]){
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
