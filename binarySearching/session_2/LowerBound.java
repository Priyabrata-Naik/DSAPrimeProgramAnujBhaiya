package binarySearching.session_2;

public class LowerBound {
    public static void main(String[] args) {

        int a[] = {1, 2, 2, 4, 4, 7, 8, 8};
        int k = 40;
        int res = lowerBound(a,k);

        System.out.println(res);

    }
    static int lowerBound(int a[], int k){
        int l = 0, r = a.length - 1;
        int ans = -1;

        while(l <= r){
            int m = l + (r-l)/2;
            if(k > a[m]){
                ans = m;
                l = m+1;
            }else if(k <= a[m]){
                r = m-1;
            }
        }
        return ans;
    }
}
