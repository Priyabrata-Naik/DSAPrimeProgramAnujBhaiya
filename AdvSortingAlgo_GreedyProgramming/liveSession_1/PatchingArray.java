package AdvSortingAlgo_GreedyProgramming.liveSession_1;

import java.util.Arrays;

public class PatchingArray {
    public static void main(String[] args) {

        int a[] = {1, 3, 12, 14};
        int n = 100;
        int res = patchingArray(a,n);

        System.out.println(res);

    }
    static int patchingArray(int a[], int n){
        int length = a.length;
        Arrays.sort(a);
        int count = 0;
        int reach = 0;
        int i = 0;

        while(reach < n){
            if(i < length && reach+1 < a[i]){
                count++;
                reach += (reach+1);
            }else if(i < length && reach+1 >= a[i]){
                reach += a[i];
                i++;
            }else{
                count++;
                reach += (reach+1);
            }
        }
        return count;
    }
}
