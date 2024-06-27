package dynamicProgrammingBasics.session_6;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

        int a[] = {2, 9, 4, 6, 10, 5};

        int ans = lis(a);

        System.out.println(ans);
        System.out.println(lisBottomUp(a));

    }

    static int lisBottomUp(int a[]){
        int n = a.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(a[i] > a[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        for (int e : dp) {
            max = Math.max(e, max);
        }
        return max;
    }

    static int lis(int a[]){
        int dp[] = new int[a.length];
        Arrays.fill(dp, -1);
        lisUtil(a, a.length - 1, dp);
        return ANS;
    }

    static int ANS = 0;

    static int lisUtil(int a[], int ind, int dp[]){
        if(ind == 0) return 1;
        int max = 1;

        if(dp[ind] != -1) return dp[ind];

        for(int i = 0; i < ind; i++){
            int listAtI = lisUtil(a, i, dp);
            if(a[i] < a[ind]){
                max = Math.max(max, listAtI + 1);
            }
        }
        ANS = Math.max(ANS, max);
        return dp[ind] = max;
    }
}
