package a_dsaPrimeDoubtNPractice.dsaArray;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {

        int a[] = {7, 3, 4, 2, 9, 12, 56};
        int m = 3;
        int res = findMinDiff(a,m);

        System.out.println( res);

    }
    public static int findMinDiff(int[] arr, int m)
    {
        //You Can Code Here
        int n = arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        if(m == 0 || n == 0)return 0;
        if(n < m)return -1;

        for(int i = 0; i+m-1 < n; i++){
            int diff = arr[i+m-1]-arr[i];
            if(diff < minDiff){
                minDiff = diff;
            }
        }
        return minDiff;
    }
}
