package dynamicProgrammingAdvanced.session_3;

import java.util.Arrays;

public class UniquePaths_1 {
    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        int ans = uniquePaths(m, n);

        System.out.println(ans);

    }

    static int uniquePaths(int m, int n){
        int dp[][] = new int[m][n];
        for(int e[]: dp) Arrays.fill(e, -1);

        return uniquePathsUtil(m, n, dp);
    }

    static int uniquePathsUtil(int m, int n, int dp[][]){
        if(m == 1 || n == 1) return 1;

        if(dp[m-1][n-1] != -1) return dp[m-1][n-1];

        return dp[m-1][n-1] = uniquePathsUtil(m-1, n, dp) + uniquePathsUtil(m, n-1, dp);
    }
}
