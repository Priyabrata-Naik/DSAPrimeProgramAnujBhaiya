package AdvSortingAlgo_GreedyProgramming.liveSession_1;

import java.util.Arrays;

public class MaxSumOfAbsoluteDifference {
    public static void main(String[] args) {

        int a[] = {1, 2, 4, 8};
        int res = maxAbsoluteDiffSumPermutation(a);

        System.out.println(res);

    }
    static int maxAbsoluteDiffSumPermutation(int a[]){
        Arrays.sort(a);
        int left = 0, right = a.length - 1;
        int sum = 0;
        boolean flip = true;

        while(left < right){
            sum += Math.abs(a[right] - a[left]);
            if(flip){
                left++;
            }else{
                right--;
            }
            flip = !flip;
        }
        sum += Math.abs(a[a.length/2] - a[0]);

        return sum;
    }
}
