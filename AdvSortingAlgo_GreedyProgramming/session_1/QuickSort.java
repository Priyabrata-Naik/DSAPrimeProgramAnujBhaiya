package AdvSortingAlgo_GreedyProgramming.session_1;

public class QuickSort {
    public static void main(String[] args) {

        int a[] = {4, 6, 2, 5, 7, 9, 1, 3};
        quickSort(a,0,a.length-1);

        for(int e: a){
            System.out.print(e+" ");
        }
        System.out.println();

    }
//    For best/avg. case T.c = O(n Log n) & for worst case T.c = O(n^2)
    static void quickSort(int a[], int l, int h){
        if(l < h){
            int pivot = partition(a,l,h);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,h);
        }
    }
    static int partition(int a[], int l, int h){
        int pivot = a[l];
        int i = l, j = h;

        while(i <= j){
            while(i <= h && a[i] <= pivot) i++;
            while(j >= l && a[j] > pivot) j--;
            if(i < j) swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }
    static void swap(int a[], int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
}
