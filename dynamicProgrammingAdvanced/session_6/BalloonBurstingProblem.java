package dynamicProgrammingAdvanced.session_6;

import java.util.Arrays;

public class BalloonBurstingProblem {
    public static void main(String[] args) {

        int a[] = {3, 1, 5, 8};

        int ans = balloonBursting(a);

        System.out.println(ans);
        System.out.println(balloonBurstingBottomUp(a));

    }

    static int balloonBurstingBottomUp(int a[]){
        int n = a.length;
        int b[] = new int[n+2];
        b[0] = b[n+1] = 1;
        for(int i = 1; i <= n; i++) b[i] = a[i-1];
        int dp[][] = new int[n+2][n+2];

        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) continue;
                int max = Integer.MIN_VALUE;
                for(int k = i; k<= j; k++){
                    int profitByInflatingK = b[k] * b[i-1] * b[j+1] +
                            dp[i][k-1] +
                            dp[k+1][j];
                    max = Math.max(max, profitByInflatingK);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n];
    }

    static int balloonBursting(int a[]){
        int n = a.length;
        int b[] = new int[n+2];
        b[0] = b[n+1] = 1;
        int dp[][] = new int[n+2][n+2];
        for(int e[]: dp) Arrays.fill(e, -1);
        for(int i = 1; i <= n; i++) b[i] = a[i-1];
        return balloonBurstingUtil(b, 1, n, dp);
    }

    static int balloonBurstingUtil(int a[], int i, int j, int dp[][]){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int profitByInflatingK = a[k] * a[i-1] * a[j+1] +
                    balloonBurstingUtil(a, i, k-1, dp) +
                    balloonBurstingUtil(a, k+1, j, dp);
            max = Math.max(max,profitByInflatingK);
        }
        return dp[i][j] = max;
    }
}
