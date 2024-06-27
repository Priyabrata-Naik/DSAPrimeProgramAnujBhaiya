package binarySearching.session_3;

public class FindTheMedianOfTwoSortedArrays {
    public static void main(String[] args) {

        int a[] = {1, 2};
        int b[] = {3, 4, 5, 6};
        int res = findMedianOfTwoSortedArrays(a,b);

        System.out.println(res);

    }
//    Logic building is in progress, need stabilisation
    static int findMedianOfTwoSortedArrays(int a[], int b[]){
        int n = a.length;
        int m = b.length;
        int arr[] = new int[m+n];
        int length = arr.length;

        for(int i = 0, j = 0, k = 0; i < length; i++){
            if(j < n){
                if(a[j] < b[k]) {
                    arr[i] = a[j];
                    j++;
                }
            }else if(k < m){

            }
        }
        if((length & 1) != 0){
            int l = 0, r = length-1;
            int md = (l+r)/2;
            return arr[md];
        }else{
            int l = 0, r = length-1;
            int firstMed = (l+r)/2;
            int secondMed = (l+r)/2+1;
            return (firstMed+secondMed)>>1;
        }
    }
    
}
