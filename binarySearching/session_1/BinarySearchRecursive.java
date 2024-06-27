package binarySearching.session_1;

public class BinarySearchRecursive {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 5, 8, 9};
        int k = -5;
        int res = binarySearchRecursive(a,k,0,a.length-1);

        System.out.println(res);

    }
    static int binarySearchRecursive(int a[], int k, int l, int r){
        if(l > r)return -1;
        int m = l + (r-l)/2;
        if(a[m] == k)return m;
        if(a[m] > k)return binarySearchRecursive(a,k,l,m-1);
        return binarySearchRecursive(a,k,m+1,r);
    }
}
