package binarySearching.session_1;

public class CountOccurrenceOfAnElement {
    public static void main(String[] args) {

        int a[] = {1, 2, 2, 2, 2, 5, 8, 8};
        int k = 50;
        int res = countOccurrence(a,k);

        System.out.println(res);

    }
    static int countOccurrence(int a[], int k){
        int fo = firstOccurrence(a,k);
        if(fo == -1) return 0;
        int lo = lastOccurrence(a,k);
        return lo - fo + 1;
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
