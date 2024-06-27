package dynamicProgrammingAdvanced.session_5;

import java.util.Arrays;

public class PalindromicPartitioning {
    public static void main(String[] args) {

        String s = "abbadcbcddade";
        int ans = palindromicPartitioning(s);

        System.out.println(ans);
        System.out.println(palindromicPartitioningBottomUp(s));

    }

//    T.C -> O(n^2), S.C -> O(n^2)
    static int palindromicPartitioningBottomUp(String s){
        int n = s.length();
        boolean pal[][] = new boolean[n][n];
        fillPalindromeMatrix(s, pal, n);
        int dp[] = new int[n];

        for(int j = 1; j < n; j++){
            if(pal[0][j]) dp[j] = 0;
            else{
                int min = Integer.MAX_VALUE;
                for(int i = j; i >= 0; i--){
                    if(pal[i][j]){
                        min = Math.min(min, dp[i-1] + 1);
                    }
                }
                dp[j] = min;
            }
        }
        return dp[n-1];
    }

    static void fillPalindromeMatrix(String s, boolean pal[][], int n){
        for(int i  = 0; i < n; i++) pal[i][i] = true;

        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n-len; i++){
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j) && (pal[i+1][j-1] || len == 2)){
                    pal[i][j] = true;
                }
            }
        }
    }

//    T.C -> O(n^3), S.C -> O(n^2)
    static int palindromicPartitioning(String s){
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int e[]: dp) Arrays.fill(e, -1);
        return palindromicPartitioningUtil(s, 0, s.length()-1, dp);
    }

    static int palindromicPartitioningUtil(String s, int i, int j, int dp[][]){
        if(i >= j || isPalindrome(s, i, j)) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            min = Math.min(min, palindromicPartitioningUtil(s, i, k, dp) + palindromicPartitioningUtil(s, k+1, j, dp) + 1);
        }

        return dp[i][j] = min;
    }

    static boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
