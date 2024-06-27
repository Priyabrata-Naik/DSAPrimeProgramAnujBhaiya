package binarySearching.session_1;

public class IndexOfFirst_LastOccurrenceOfAnElementInSortedArray {
    public static void main(String[] args) {

        int a[] = {1, 2, 2, 2, 4, 5, 8, 8};
        int k = 8;
        int res = lastOccurrence(a,k);

        System.out.println(res);

    }
    static int lastOccurrence(int a[], int k){
        int l = 0, r = a.length-1;
        int ans = -1;

        while (l <= r) {
            int m = l + (r-l)/2;
            if(k < a[m]){
                r = m-1;
            }else if(k > a[m]){
                l = m+1;
            }else{
                l = m + 1;
                ans = m;
            }
        }
        return ans;
    }
    static int firstOccurrence(int a[], int k){
        int l = 0, r = a.length-1;
        int ans = -1;

        while (l <= r) {
            int m = l + (r-l)/2;
            if(k < a[m]){
                r = m-1;
            }else if(k > a[m]){
                l = m+1;
            }else{
                r = m-1;
                ans = m;
            }
        }
        return ans;
    }
}
