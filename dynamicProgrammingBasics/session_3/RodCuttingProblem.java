package dynamicProgrammingBasics.session_3;

import java.util.Arrays;

public class RodCuttingProblem {
    public static void main(String[] args) {

        int n = 8;
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        int ans = rodCuttingProblem(n, price, n, dp);

        System.out.println(ans);
        System.out.println(rodCuttingProblemBottomUp(n, price));

//        for(int e: dp){
//            System.out.print(e+" ");
//        }

    }
    static int rodCuttingProblem(int n, int v[], int i, int dp[]){
        if(i <= 0) return 0;
        int max = 0;

        if(dp[i] != -1) return dp[i];

        for(int len = 1; len <= i; len++){
            int profitAtThisCut = v[len-1] + rodCuttingProblem(n, v, i-len, dp);
            max = Math.max(max, profitAtThisCut);
        }
        return dp[i] = max;
    }

    static int rodCuttingProblemBottomUp(int n, int v[]){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = v[0];

        for(int i = 2; i <= n; i++){
            for(int cut = 1; cut <= i; cut++){
                dp[i] = Math.max(dp[i], v[cut-1] + dp[i-cut]);
            }
        }

        return dp[n];
    }
}
