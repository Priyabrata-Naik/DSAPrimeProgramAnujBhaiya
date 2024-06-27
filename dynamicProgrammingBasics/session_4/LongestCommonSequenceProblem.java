package dynamicProgrammingBasics.session_4;

import java.util.Arrays;

public class LongestCommonSequenceProblem {
    public static void main(String[] args) {

        String a = "abcde";
        String b = "ace";

        int ans = lcs(a,b);

        System.out.println(ans);
        System.out.println(lcsBottomUp(a, b));
        System.out.println(lcsBottomUpOp(a, b));

    }

    static int lcsBottomUpOp(String a, String b){
        int m = a.length();
        int n = b.length();

        int arr1[] = new int[n+1];
        int arr2[] = new int[n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    arr2[j] = arr1[j-1] + 1;
                }else{
                    arr2[j] = Math.max(arr1[j], arr2[j-1]);
                }
            }
            for(int j = 1; j <= n; j++){
                arr1[j] = arr2[j];
            }
        }
        return arr2[n];
    }

    static int lcsBottomUp(String a, String b){
        int m = a.length();
        int n = b.length();
        int dp[][] = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

//        for(int i = 0; i <= m; i++){
//            for(int j = 0; j <= n; j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        return dp[m][n];
    }

    static int lcs(String a, String b){
        int l1 = a.length();
        int l2 = b.length();
        int dp[][] = new int[l1][l2];

        for(int e[]: dp){
            Arrays.fill(e, -1);
        }

        return lcsUtil(a, b, l1-1, l2-1, dp);
    }
    static int lcsUtil(String a, String b, int i, int j,int dp[][]){
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return dp[i][j] = lcsUtil(a, b, i-1, j-1, dp) + 1;
        }else{
            dp[i][j] = Math.max((lcsUtil(a, b, i-1, j, dp)), (lcsUtil(a, b, i, j-1, dp)));
            return dp[i][j];
        }
    }
}
