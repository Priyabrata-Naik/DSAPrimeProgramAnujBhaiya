package dynamicProgrammingAdvanced.liveSession_1;

import java.util.Arrays;

public class OptimalStrategyForGame {
    public static void main(String[] args) {

        int a[] = {8, 15, 3, 7};

        int ans = optimalStrategyForGame(a);

        System.out.println(ans);

    }

    static int optimalStrategyForGame(int a[]){
        int n = a.length;
        int dp[][] = new int[n][n];
        for(int e[]: dp) Arrays.fill(e, -1);
        return optimalStrategyForGameUtil(a, 0, n-1, dp);
    }

    static int optimalStrategyForGameUtil(int a[], int i, int j, int dp[][]){
        int n = a.length;
        if(i > j || i >= n || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int option1 = a[i] + Math.min(optimalStrategyForGameUtil(a, i+2, j, dp), optimalStrategyForGameUtil(a, i+1, j-1, dp));
        int option2 = a[j] + Math.min(optimalStrategyForGameUtil(a, i, j-2, dp), optimalStrategyForGameUtil(a, i+1, j-1, dp));

        return dp[i][j] = Math.max(option1, option2);
    }
}
