package dynamicProgrammingBasics.session_1;

public class ClimbStairsBottomUpApproach {
    public static void main(String[] args) {

        int n = 8;

        System.out.println(climbingStairsBottomUp(n));
        System.out.println(climbingStairsBottomUpOptimised(n));

    }

//    T.C = O(n), S.C = O(n)
    static int climbingStairsBottomUp(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }

//    T.C = O(n), S.C = O(1)
    static int climbingStairsBottomUpOptimised(int n){
        if(n == 0) return 1;
        if(n <= 2) return n;

        int first = 1;
        int second = 1;
        int third = 2;

        for(int i = 3; i <= n; i++){
            int res = first + second + third;
            first = second;
            second = third;
            third = res;
        }

        return third;
    }
}
