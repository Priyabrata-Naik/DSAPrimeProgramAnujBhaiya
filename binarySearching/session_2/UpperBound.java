package binarySearching.session_2;

public class UpperBound {
    public static void main(String[] args) {

        int a[] = {1, 2, 2, 2, 4, 4, 6, 8, 10};
        int k = 1;
        int res = upperBound(a,k);

        System.out.println(res);

    }
    static int upperBound(int a[], int k){
        int l = 0, r = a.length-1;
        int ans = a.length;

        while(l <= r){
            int m = l + (r-l)/2;
            if(k < a[m]){
                ans = m;
                r = m-1;
            }else if(k >= a[m]){
                l = m+1;
            }
        }
        return ans;
    }
}
