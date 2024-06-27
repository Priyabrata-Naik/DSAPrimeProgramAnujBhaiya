package bitManipulation_Mathematics.session_4;

import java.util.Arrays;

public class PrimeQueries {
    public static void main(String[] args) {

//        int n = 20;
//        boolean ans[] = sieveOfEratosthenes(n);
//
//        for(int i = 0; i <= n; i++){
//            if(ans[i]){
//                System.out.println(i);
//            }
//        }
        int a[][] = {
                {2, 8},
                {6, 12},
                {3, 9}
        };
        int res[] = primeQueries(a);

        for(int e: res){
            System.out.print(e+" ");
        }

    }
    static int[] primeQueries(int q[][]){
        int n = q.length;
//        System.out.println(n);
        int length = 0;

        for(int i = 0; i < n; i++){
            length = Math.max(length, q[i][1]);
        }
        boolean isPrime[] = sieveOfEratosthenes(length);
        int count[] = new int[length+1];

        for(int i = 1; i <= length; i++){
            if(isPrime[i]){
                count[i] = count[i-1]+1;
            }else{
                count[i] = count[i-1];
            }
        }
        int ans[] = new int[n];

        for(int i = 0; i < n; i++){
            int leftCount = count[q[i][0]-1];
            int rightCount = count[q[i][1]];
            ans[i] = rightCount - leftCount;
        }
        return ans;
    }
    static boolean[] sieveOfEratosthenes(int n){
        boolean isPrime[] = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i*i <= n; i++){
            for(int j = i * i; j <= n; j += i){
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
