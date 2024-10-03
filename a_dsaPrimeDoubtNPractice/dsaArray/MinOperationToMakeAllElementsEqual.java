package a_dsaPrimeDoubtNPractice.dsaArray;

import java.util.Arrays;

public class MinOperationToMakeAllElementsEqual {
    public static void main(String[] args) {

        int a[][] = {
                {6, 4},
                {22, 24}
        };
        int k = 2;
        int ans = minOperationToMakeEqualElements(a, k);

        System.out.println(ans);

    }

    static int minOperationToMakeEqualElements(int a[][], int k){
        int n = a.length;
        int m = a[0].length;
        int total = n * m;
        int b[] = new int[total];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i*m+j] = a[i][j];
            }
        }
        Arrays.sort(b);
        int median = b[total>>1];

        return helper(b, median, k);
    }

    static int helper(int a[], int m, int k){
        int step = 0;

        for(int i = 0; i < a.length; i++){
            int absVal = Math.abs(a[i] - m);
            if(absVal % k == 0){
                step += absVal/k;
            }else{
                return -1;
            }
        }
        return step;
    }

}
