package binarySearching.liveSession_1;

import java.util.Arrays;

public class MedianOfRowWiseSortedMatrix {
    public static void main(String[] args) {

        int a[][] = {
                {1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}
        };
        int res = medianOfRowWiseSortedMatrixOp(a);

        System.out.println(res);
        
    }
    static int medianOfRowWiseSortedMatrixOp(int a[][]){
        int r = a.length;
        int c = a[0].length;
        int size = r * c;
        int desired = size / 2;
        int ans = -1;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < r; i++){
            min = Math.min(min, a[i][0]);
            max = Math.max(max, a[i][c-1]);
        }
        int l = min, h = max;

        while(l < h){
            int m = l + (h-l)/2;
            int count = 0;
            for(int i = 0; i < r; i++){
                count += upperBound(a[i], m);
            }

            if(count <= desired){
                l = m+1;
            }else{
                ans = m;
                h = m;
            }
        }
        return ans;
    }
    static int upperBound(int a[], int k){
        int l = 0, r = a.length-1;
        int ans = a.length;
        while(l <= r){
            int m = l + (r-l)/2;
            if(k >= a[m]){
                l = m+1;
            }else{
                ans = m;
                r = m-1;
            }
        }
        return ans;
    }
//    BruteForce way
    static int medianOfSortedMatrix(int a[][]){
        int n = a.length;
        int m = a[0].length;
        int size = n * m;
        int newArray[] = new int[size];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                newArray[i * n + j] = a[i][j];
            }
        }
        Arrays.sort(newArray);
        return newArray[size/2];
    }
}
