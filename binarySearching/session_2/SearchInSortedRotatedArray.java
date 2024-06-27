package binarySearching.session_2;

public class SearchInSortedRotatedArray {
    public static void main(String[] args) {

        int a[] = {10, 10, 1, 4, 5, 9, 9};
        int k = 10;
        int res = findInSortedRotatedArray(a,k);

        System.out.println(res);

    }
//    For average case T(N) = O(log n) and for worst case T(N) = O(n)
    static int findInSortedRotatedArray(int a[], int k){
        int l = 0, r = a.length-1;

        while(l <= r){
            int m = l + (r-l)/2;
            if(k == a[m])return m;
            if(a[m] == a[l] && a[m] == a[r]){
                l++;
                r--;
            }else if(a[l] <= a[m]){
                if(k >= a[l] && k < a[m]){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if(k > a[m] && k <= a[r]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
