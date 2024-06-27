package binarySearching.session_3;

public class SquareRootOfAnInteger {
    public static void main(String[] args) {

        int a = 90;
        int res = sqrt(a);

        System.out.println(res);

    }
//    T(n) = O(n^1/2)
    static int squareRootOfInteger(int n){
        int ans = 1;
        for(int i = 1; i * i <= n; i++){
            ans = i;
        }
        return ans;
    }
    static int sqrt(int n){
        int l = 1, r = n;
        int ans = -1;
        while(l <= r){
            int m = l + (r-l)/2;
            if(m * m == n)return m;
            if(m * m > n){
                r = m-1;
            }else{
                l = m+1;
                ans = m;
            }
        }
        return ans;
    }
}
