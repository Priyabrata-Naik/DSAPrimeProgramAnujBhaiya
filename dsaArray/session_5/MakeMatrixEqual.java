package dsaArray.session_5;

import java.util.Arrays;

public class MakeMatrixEqual {
    public static void main(String[] args) {

        int a[][] = {
                {3, 63, 42},
                {18, 12, 12},
                {15, 21, 18},
                {33, 84, 24}
        };
        int k = 3;
        int ans = makeMatrixEqual(a,k);

        System.out.println(ans);

    }
//    ONE EDGE CASE IS PENDING, IT SHOULD RETURN -1 IF NO SOLUTION IS POSSIBLE
    static int makeMatrixEqual(int a[][], int k){
        int n = a.length;
        int m = a[0].length;
        int total = n*m;
        int b[] = new int[total];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                b[i*m+j] = a[i][j];
            }
        }
        Arrays.sort(b);
        int median = b[total/2];
//        for(int i = 0; i < total; i++){
//            System.out.println(i+" "+b[i]+" "+ helper(b, b[i], k));
//        }
        return helper(b,median,k);
    }
    static int helper(int b[], int m, int k){
        int count = 0;
        for(int i = 0; i < b.length; i++){
            count += Math.abs(b[i]-m)/k;
        }
        return count;
    }
}
