package AdvSortingAlgo_GreedyProgramming.session_2;

public class MergeSort {
    public static void main(String[] args) {

        int a[] = {6, 5, 12, 10, 9, 1};
        mergeSort(a,0,a.length-1);

        for(int e: a){
            System.out.print(e+" ");
        }

    }
    static void mergeSort(int a[], int l, int h){
        if(l < h){
            int m = (l+h+1)/2;
            mergeSort(a,l,m-1);
            mergeSort(a,m,h);
            merge(a,l,m,h);
        }
    }
    static void merge(int a[], int l, int m, int h){
        int n1 = m - l;
        int n2 = h - m + 1;
        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = l; i < m; i++){
            L[i-l] = a[i];
        }
        for(int i = m; i <= h; i++){
            R[i-m] = a[i];
        }
        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2){
            if(L[i] < R[j]){
                a[k] = L[i];
                i++;
            }else{
                a[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            a[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            a[k] = R[j];
            j++;
            k++;
        }
    }
}
