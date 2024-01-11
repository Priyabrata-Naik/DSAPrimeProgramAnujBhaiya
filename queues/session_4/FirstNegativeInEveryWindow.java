package queues.session_4;

import java.util.ArrayDeque;

public class FirstNegativeInEveryWindow {
    public static void main(String[] args) {

        int a[] = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        int ans[] = firstNegativeInEveryWindowOp(a,k);

        for(int e: ans){
            System.out.print(e+" ");
        }

    }
    public static int[] firstNegativeInEveryWindowOp(int a[], int k){
        int n = a.length;
        int ans[] = new int[n-k+1];
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int i = 0;
        while(i < k){
            if(a[i] < 0){
                dq.offerLast(a[i]);
            }
            i++;
        }

        for(; i < n; i++){
            if(dq.isEmpty()){
                ans[i-k] = 0;
            }else{
                ans[i-k] = dq.getFirst();
            }
            if(!dq.isEmpty() && a[i-k] == dq.getFirst()){
                dq.pollFirst();
            }
            if(a[i] < 0){
                dq.offerLast(a[i]);
            }
        }
        if(dq.isEmpty()){
            ans[i-k] = 0;
        }else{
            ans[i-k] = dq.getFirst();
        }
        return ans;
    }
}
