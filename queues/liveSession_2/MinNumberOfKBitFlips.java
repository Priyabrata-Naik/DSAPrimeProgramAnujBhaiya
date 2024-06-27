package queues.liveSession_2;

import java.util.LinkedList;
import java.util.Queue;

public class MinNumberOfKBitFlips {
    public static void main(String[] args) {

        int a[] = {0, 0, 0, 1, 0, 1, 1, 0};
        int k = 3;
        int res = flipBits(a,k);

        System.out.println(res);

    }
    static int flipBits(int a[], int k){
        int n = a.length;
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for(int i = 0; i < n; i++){
            if((q.size()&1) != 0){
                a[i] = a[i] ^ 1;
            }
            if(a[i] == 0){
                if(i + k > n){
                    return -1;
                }
                count++;
                q.offer(i+k-1);
            }
            if(!q.isEmpty() && q.peek() == i){
                q.poll();
            }
        }
        return count;
    }
}
