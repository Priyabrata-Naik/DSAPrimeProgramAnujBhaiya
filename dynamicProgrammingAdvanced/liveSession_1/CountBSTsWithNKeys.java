package dynamicProgrammingAdvanced.liveSession_1;

import java.util.Arrays;

public class CountBSTsWithNKeys {
    public static void main(String[] args) {

        int n = 4;

        int ans = countBSTs(n);

        System.out.println(ans);
        System.out.println(countBSTsBottomUp(n));

    }

    static int countBSTsBottomUp(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++){
            int count = 0;
            for(int j = 1; j <= i; j++){
                count += dp[j-1] * dp[i-j];
            }
            dp[i] = count;
        }
        return dp[n];
    }

    static int countBSTs(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return countBSTsUtil(n, dp);
    }

    static int countBSTsUtil(int n, int dp[]){
        if(n == 0 || n == 1) return 1;

        if(dp[n] != -1) return dp[n];

        int count = 0;
        for(int i = 1; i <= n; i++){
            count += countBSTsUtil(i-1, dp) * countBSTsUtil(n-i, dp);
        }

        return dp[n] = count;
    }
}
