package dynamicProgrammingAdvanced.session_2;

public class SubsetSumProblem {
    public static void main(String[] args) {

        int a[] = {3, 34, 4, 12, 5, 2};
        int sum = 3;

        boolean ans = subsetSum(a, sum);

        System.out.println(ans);

    }

    static boolean subsetSum(int a[], int sum){
        Boolean dp[][] = new Boolean[a.length][sum+1];
        return subsetSumUtil(a, sum, a.length-1, dp);
    }

    static boolean subsetSumUtil(int a[], int sum, int ind, Boolean dp[][]){
        if(sum == 0) return true;
        if(ind == -1) return false;

        if(dp[ind][sum] != null) return dp[ind][sum];

        if(a[ind] > sum) return dp[ind][sum] = subsetSumUtil(a, sum, ind-1, dp);

        boolean picked = subsetSumUtil(a, sum - a[ind], ind-1, dp);
        boolean notPicked = subsetSumUtil(a, sum, ind-1, dp);

        return dp[ind][sum] = picked || notPicked;
    }
}
