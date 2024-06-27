package AdvSortingAlgo_GreedyProgramming.session_5;

import java.util.Arrays;

public class DistributeCandies {
    public static void main(String[] args) {

        int a[] = {3, 1, 4, 2, 1, 3};
        int res = candyDistribution(a);

        System.out.println(res);

    }
    static int candyDistribution(int a[]){
        int n = a.length;
        int candy[] = new int[n];
        Arrays.fill(candy, 1);

        for(int i = 1; i < n; i++){
            if(a[i] > a[i-1]){
                candy[i] = candy[i-1] + 1;
            }
        }
        for(int i = n-2; i >= 0; i--){
            if(a[i] > a[i+1] && candy[i] <= candy[i+1]){
                candy[i] = candy[i+1] + 1;
            }
        }
        int sum = 0;
        for(int e: candy) sum += e;

        return sum;
    }
}
