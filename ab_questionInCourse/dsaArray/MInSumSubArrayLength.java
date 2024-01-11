package ab_questionInCourse.dsaArray;

public class MInSumSubArrayLength {
    public static void main(String[] args) {

        int a[] = {2, 3, 1, 2, 4, 6};
        int k = 6;
        int res = minSubArrayLength(a,k);

        System.out.println( res);

    }
    static int minSubArrayLength(int a[], int k){
        int n = a.length;
        int length = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int sum = 0;
            if(a[i] == k){
                length = 1;
                break;
            }
            for(int j = i+1; j < n; j++){
                if(sum == 0){
                    sum += a[i]+a[j];
                }else{
                    sum += a[j];
                }
//                System.out.println(sum);
                if(sum >= k){
                    int curLength = j-i+1;
                    length = Math.min(curLength,length);
                }
//                System.out.println(length);
            }
        }
        if(length == Integer.MAX_VALUE){
            return 0;
        }
        return length;
    }
    static int minSubArrayLengthOp(int a[], int k){
        int minLength = Integer.MAX_VALUE;
        int n = a.length;
        int sum = 0;
        int l = 0, r = 0;

        while(r < n){
            sum += a[r];
            while(sum >= k){
                if(r-l+1 < minLength){
                    minLength = r-l+1;
                }
                sum -= a[l];
                l++;
            }
            r++;
        }
        return minLength;
    }
}
