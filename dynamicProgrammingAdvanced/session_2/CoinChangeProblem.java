package dynamicProgrammingAdvanced.session_2;

import java.util.Arrays;

public class CoinChangeProblem {
    public static void main(String[] args) {

        int a[] = {1, 5, 8};
        int amount = 15;

        int ans = countMinCoins(a, amount);

        System.out.println(ans);
        System.out.println(countMinCoinsBottomUp(a, amount));

    }

    static int countMinCoinsBottomUp(int a[], int amount){
        int dp[] = new int[amount+1];

        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int e: a){
                if(i >= e){
                    min = Math.min(min, 1 + dp[i-e]);
                }
            }
            dp[i] = min;
        }
        return dp[amount];
    }

    static int countMinCoins(int a[], int amount){
        int dp[] = new int[amount+1];
        Arrays.fill(dp, -1);
        return countMinCoinsUtil(a, amount, dp);
    }

    static int countMinCoinsUtil(int a[], int amount, int dp[]){
        if(amount == 0) return 0;
        if(amount < 0) return Integer.MAX_VALUE;

        if(dp[amount] != -1) return dp[amount];

        int min = Integer.MAX_VALUE;

        for(int e: a){
            int count = countMinCoinsUtil(a, amount-e, dp);
            if(count < min){
                min = count;
            }
        }

        if(min == Integer.MAX_VALUE) return -1;

        return dp[amount] = min + 1;
    }
}
