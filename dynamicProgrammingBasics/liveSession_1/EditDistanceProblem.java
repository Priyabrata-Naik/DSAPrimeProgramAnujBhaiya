package dynamicProgrammingBasics.liveSession_1;

import java.util.Arrays;

public class EditDistanceProblem {
    public static void main(String[] args) {

        String s1 = "sunday";
        String s2 = "saturday";

        int ans = editDistance(s1, s2);

        System.out.println(editDistanceBottomUpOptimised(s1, s2));
        System.out.println(ans);

    }

    static int editDistanceBottomUpOptimised(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int a[] = new int[n+1];
        int b[] = new int[n+1];

        for(int i = 0; i <= n; i++){
            a[i] = i;
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s2.charAt(i-1) == s1.charAt(j-1)){
                    b[j] = a[j-1];
                }else{
                    b[j] = Math.min(Math.min(a[j], b[j-1]), a[j-1]) + 1;
                }
            }

            System.out.println("A array");
            for(int j = 1; j <= n; j++){
                System.out.print(a[j] + " ");
            }
            System.out.println();
            System.out.println("B array");
            for(int j = 1; j <= n; j++){
                System.out.print(b[j]+ " ");
            }
            System.out.println();

            for(int j = 0; j <= n; j++){
                a[j] = b[j];
            }
        }


        return b[n];
    }

    static int editDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n][m];
        for(int e[]: dp) Arrays.fill(e, -1);
        return editDistanceUtil(s1, s2, n-1, m-1, dp);
    }

    static int editDistanceUtil(String s1, String s2, int i , int j, int dp[][]){
        if(i == -1) return j+1;
        if(j == -1) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = editDistanceUtil(s1, s2, i-1, j-1, dp);
        }

        return dp[i][j] = Math.min(Math.min(editDistanceUtil(s1, s2, i, j-1, dp), editDistanceUtil(s1, s2, i-1, j, dp)),
                editDistanceUtil(s1, s2, i-1, j-1, dp)) + 1;
    }
}
