package dynamicProgrammingAdvanced.session_1;

import java.util.Arrays;

public class ZeroOneKnapsackProblem {
    public static void main(String[] args) {

        int W = 4;
        int w[] = {1, 2, 3};
        int v[] = {30, 40, 60};
        int ans = zeroOneKnapsack(W, v, w);

        System.out.println(ans);
        System.out.println(zeroOneKnapsackBottomUp(W, v, w));

    }

    static int zeroOneKnapsackBottomUp(int W, int v[], int w[]){
        int item = v.length;
        int dp[][] = new int[item+1][W+1];

        for(int i = 1; i <= item; i++){
            for(int curCap = 1; curCap <= W; curCap++){
                if(w[i-1] > curCap){
                    dp[i][curCap] = dp[i-1][curCap];
                }else{
                    int take = v[i-1] + dp[i-1][curCap-w[i-1]];
                    int notTake = dp[i-1][curCap];
                    dp[i][curCap] = Math.max(take, notTake);
                }
                System.out.print(dp[i][curCap]+" ");
            }
            System.out.println();
        }
        return dp[item][W];
    }

    static int zeroOneKnapsack(int W, int v[], int w[]){
        int dp[][] = new int[v.length][W+1];
        for(int e[]: dp) Arrays.fill(e, -1);
        zeroOneKnapsackUtil(W, v, w, w.length-1, dp);
        return dp[v.length-1][W];
    }

    static int zeroOneKnapsackUtil(int W, int v[], int w[], int i, int dp[][]){
        if(i == -1) return 0;

        if(dp[i][W] != -1) return dp[i][W];

        if(w[i] > W) return dp[i][W] = zeroOneKnapsackUtil(W, v, w, i-1, dp);
        else{
            int take = v[i] + zeroOneKnapsackUtil(W-w[i], v, w, i-1, dp);
            int notTake = zeroOneKnapsackUtil(W, v, w, i-1, dp);
            return dp[i][W] = Math.max(take, notTake);
        }
    }
}
