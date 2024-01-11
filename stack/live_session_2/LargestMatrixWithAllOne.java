package stack.live_session_2;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class LargestMatrixWithAllOne {
    public static void main(String[] args) {

        int a[][] = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        int ans = largestMatrixWithAllOne(a);

        System.out.println(ans);

    }
    static void printArray(int a[]){
        for(int e: a){
            System.out.print(e+" ");
        }
        System.out.println();
    }
    static int largestMatrixWithAllOne(int a[][]){
        int row = a.length;
        if(row == 0) return 0;
        int col = a[0].length;
        int maxArea = 0;
        int his[] = new int[col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(a[i][j] == 0){
                    his[j] = 0;
                }else{
                    his[j]++;
                }
            }
            printArray(his);
            int curArea = maxAreaHistogram(his);
            System.out.println("Matrix area -> " + curArea);
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
    static int maxAreaHistogram(int a[]){
        int n = a.length;
        int maxArea = 0;
        int left[] = smallOnLeft(a);
        int right[] = smallOnRight(a);
        printArray(left);
        printArray(right);

        for(int i = 0; i < n; i++){
            int area = (right[i]-left[i]-1)*a[i];
            System.out.println( "Histogram area -> " +  area);
            maxArea = Math.max(maxArea,area);
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
