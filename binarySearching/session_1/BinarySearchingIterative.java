package binarySearching.session_1;

public class BinarySearchingIterative {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 6, 8, 9};
        int k = 9;
        int res = binarySearchIterative(a,k);

        System.out.println(res);

    }
    static int binarySearchIterative(int a[], int k){
        int l = 0, r = a.length - 1;

        while(l <= r){
            int m = l + (r-l)/2;
            if(k == a[m])return m;
            if(k < a[m]){
                r = m-1;
            }else if(k > a[m]){
                l = m + 1;
            }
        }
        return -1;
    }
}
