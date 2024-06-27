package a_dsaPrimeDoubtNPractice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MInNumberOfKBitFlip {
    public static void main(String[] args) {

        int a[] = {0, 1, 0, 1, 1, 0, 0, 1};
        int k = 2;
        int res = flipBits(a,k);

        System.out.println(res);

    }
    static int flipBits(int a[], int k){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = a.length;

        for(int i = 0; i < n; i++){
            if((q.size()&1) != 0){
                a[i] = a[i]^1;
            }
            if(a[i] == 0){
                if(i+k > n){
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
