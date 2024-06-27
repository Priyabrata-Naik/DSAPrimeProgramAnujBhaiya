package binarySearching.session_3;

public class FindTheMedianTwoSortedArrays {
    public static void main(String[] args) {

        int a[] = {1, 2};
        int b[] = {3, 4};
        double res = medianOfTwoSortedArrays(a, b);

        System.out.println(res);

    }
    static double medianOfTwoSortedArrays(int a[], int b[]){
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;
        int left = (n+1)/2;

        if(n1 > n2)return medianOfTwoSortedArrays(b,a);

        int l = 0, r = n1;

        while(l <= r){
            int m1 = l + (r-l)/2;
            int m2 = left - m1;
            int l1 = m1 <= 0 ? Integer.MIN_VALUE : a[m1-1];
            int l2 = m2 <= 0 ? Integer.MIN_VALUE : b[m2-1];
            int r1 = m1 >= n1 ? Integer.MAX_VALUE : a[m1];
            int r2 = m2 >= n2 ? Integer.MAX_VALUE : b[m2];

            if(l1 <= r2 && l2 <= r1){
                if(n%2 == 0){
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }else{
                    return Math.max(l1, l2);
                }
            }else if(l1 > r2){
                r = m1 - 1;
            }else if(l2 > r1){
                l = m1 + 1;
            }
        }
        return 0;
    }
}
