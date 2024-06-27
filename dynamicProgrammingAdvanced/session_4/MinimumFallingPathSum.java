package dynamicProgrammingAdvanced.session_4;

public class MinimumFallingPathSum {
    public static void main(String[] args) {

        int a[][] = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };

        int ans = minFallingPathSum(a);

        System.out.println(ans);

    }

    static int minFallingPathSum(int a[][]){
        int row = a.length;
        int col = a[0].length;

        int dp1[] = new int[col+2];
        int dp2[] = new int[col+2];

        dp1[0] = Integer.MAX_VALUE;
        dp1[col+1] = Integer.MAX_VALUE;

        for(int i = 1; i <= col; i++){
            dp1[i] = a[row-1][i-1];
        }

        for(int i = row-2; i >= 0; i--){
            for(int j = 1; j <= col; j++){
                int min = Math.min(Math.min(dp1[j-1], dp1[j]), dp1[j+1]);
                dp2[j] = min + a[i][j-1];
            }
            for(int j = 1; j <= col; j++){
                dp1[j] = dp2[j];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= col; i++) min = Math.min(min, dp2[i]);

        return min;
    }
}
