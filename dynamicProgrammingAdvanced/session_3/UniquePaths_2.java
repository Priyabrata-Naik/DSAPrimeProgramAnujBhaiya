package dynamicProgrammingAdvanced.session_3;

public class UniquePaths_2 {
    public static void main(String[] args) {

        int a[][] = {
                {0, 0, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };

        int ans = uniquePaths2(a);

        System.out.println(ans);

    }

    static int uniquePaths2(int a[][]){
        int m = a.length;
        int n = a[0].length;
        if(a[m-1][n-1] == 1) return 0;
        int dp[][] = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--){
            for(int j = n-1; j >= 0; j--){
                if(i == m-1 && j == n-1) continue;
                if(a[i][j] == 1) dp[i][j] = 0;
                else{
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
