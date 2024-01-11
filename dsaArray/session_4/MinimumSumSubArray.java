package dsaArray.session_4;

public class MinimumSumSubArray {
    public static void main(String[] args) {

        int a[] = {1, 2, 5, 6, 7, 2};
        int k = 9;
        int res = sumWithMinLength(a,k);
        int ans = minSumSubArrayLengthByMe(a,k);
        int finalAns = minSumSubArrayLengthOp(a,k);

        System.out.println(finalAns);

        System.out.println(ans);

        System.out.println(res);

    }
    static int sumWithMinLength(int a[],int sum){
        int length = Integer.MAX_VALUE;
        int n = a.length;
        int ans = 0;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(a[i] == sum || a[j] == sum){
                    return 1;
                }
                ans = a[i] + a[j];
                if(ans >= sum){
                    if(length > j - i+1){
                        length = j - i +1;
                    }
                }
            }
        }
        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
//    NEED OPTIMISATION FOR LENGTH 1
    static int minSumSubArrayLengthByMe(int a[], int target){
        int length = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int n = a.length;
        int sum = 0;
        int value = -1;

        while(l <= r && r < n){
            if(r != value){
                sum +=  a[r];
            }
//            System.out.println("sum->" +sum);
            if(sum >= target){
//                System.out.println("difference->"+(r-l+1));
                length = Math.min(length, r - l +1);
            }
            value = r;
            if(sum < target){
                r++;
            }else{
                sum -= a[l];
                l++;
            }
        }
        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
    static int minSumSubArrayLengthOp(int a[], int target){
        int l = 0,r = 0;
        int x = -1, y = -1;
        int n = a.length;
        int minLength = Integer.MAX_VALUE;
        int curSum = 0;

        while(r < n){
            curSum += a[r];
            while(curSum >= target){
//                minLength = Math.min(minLength,r-l+1);
                if(r-l+1 < minLength){
                    minLength = r-l+1;
                    x = l;
                    y = r;
                }
                curSum -= a[l];
                l++;
            }
            r++;
        }
        if(minLength == Integer.MAX_VALUE){
            minLength = 0;
        }
        System.out.println(x+" "+y);
        return minLength;

    }
}
