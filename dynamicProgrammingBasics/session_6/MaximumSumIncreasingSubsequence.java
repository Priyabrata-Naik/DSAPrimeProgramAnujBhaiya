package dynamicProgrammingBasics.session_6;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {

        int a[] = {1, 108, 2, 3, 100, 4, 5};

        int ans = maxSumInIncreasingSubsequence(a);

        System.out.println(ans);

    }
    static int maxSumInIncreasingSubsequence(int a[]){
        int n = a.length;
        int dp[] = new int[n];
        dp[0] = a[0];
        int ans = 0;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int sum = a[i] + dp[j];
                if(a[i] > a[j]){
                    dp[i] = Math.max(sum, dp[i]);
                }
            }
        }
        for(int e: dp){
            ans = Math.max(ans, e);
        }
        return ans;
    }
}
