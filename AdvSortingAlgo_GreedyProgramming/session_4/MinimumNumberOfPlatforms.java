package AdvSortingAlgo_GreedyProgramming.session_4;

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
    public static void main(String[] args) {

        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};

        int res = minPlatforms(arr, dep);

        System.out.println(res);

    }
    static int minPlatforms(int arr[], int dep[]){
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int count = 0, maxCount = 0;

        while(i < n){
            if(arr[i] <= dep[j]){
                count++;
                maxCount = Math.max(maxCount, count);
                i++;
            }else{
                count--;
                j++;
            }
        }
        return maxCount;
    }
}
