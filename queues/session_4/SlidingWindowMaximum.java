package queues.session_4;

import java.util.ArrayDeque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {

        int a[] = {2, 3, 1, 4, 5, 3, 2, 1, 4};
        int k = 3;
        int ans[] = slidingWindowMaximumOp(a,k);

        for(int e: ans){
            System.out.print(e+" ");
        }

    }
    public static int[] slidingWindowMaximumOp(int a[], int k){
        int n = a.length;
        int ans[] = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        while(i < k){
            while(!dq.isEmpty() && dq.getLast() < a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
            i++;
        }

        for(; i < n; i++){
            ans[i-k] = dq.getFirst();
            if(a[i-k] == dq.getFirst()){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && dq.getLast() < a[i]){
                dq.pollLast();
            }
            dq.offerLast(a[i]);
        }
        ans[i-k] = dq.getFirst();

        return ans;
    }
}
