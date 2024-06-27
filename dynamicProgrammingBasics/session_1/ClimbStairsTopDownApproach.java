package dynamicProgrammingBasics.session_1;

import java.util.Arrays;

public class ClimbStairsTopDownApproach {
    public static void main(String[] args) {

        int n = 8;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = climbingStairsTopDown(n, dp);

        System.out.println(ans);

    }
    static int climbingStairsTopDown(int n, int dp[]){
        if(n < 0) return 0;
        if(n == 0) return 1;

//        System.out.println("DP Array");
//        for(int e: dp){
//            System.out.print(e+" ");
//        }
//        System.out.println();

        if(dp[n] != -1) return dp[n];

        return dp[n] = climbingStairsTopDown(n-1, dp) + climbingStairsTopDown(n-2, dp) + climbingStairsTopDown(n-3, dp);
    }
}
