package a_dsaPrimeDoubtNPractice.dsaArray;

public class MinimumSubArrayProblem {
    public static void main(String[] args) {

        int a[] = {1, 2, 5, 6, 7, 2};
        int k = 4;
        int ans = minimumSumSubArrayLength(a, k);

        System.out.println(ans);
        System.out.println(solOp(a, k));

    }

//    PROBLEM IS SOLVED, BUT T.C O(N^2), S.C O(N)
    static int minimumSumSubArrayLength(int[] a, int k){
        int n = a.length;
        int preSum[] = new int[n];
        int len = Integer.MAX_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++){
            sum += a[i];
            preSum[i] = sum;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(a[i] == k) return 1;
                if(preSum[j] - preSum[i] >= k){
                    int curLen = j - i;
                    if(curLen < len){
                        len = curLen;
                        break;
                    }
                }
            }
        }
        if(len == Integer.MAX_VALUE) return 0;
        return len;
    }

    static int solOp(int a[], int k){
        int n = a.length;
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        int l = 0, r = 0;

        while(r < n){
            curSum += a[r];
            while(curSum >= k){
                int len = r - l + 1;
                if(len < minLen) minLen = len;
                curSum -= a[l];
                l++;
            }
            r++;
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}
