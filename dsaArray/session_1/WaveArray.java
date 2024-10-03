package dsaArray.session_1;

import java.util.Arrays;

public class WaveArray {
    public static void main(String[] args) {

        int arr[] = {1, 9, 5, 2, 0, 7, 4, 8, 3, 6};
        int b[] = {6, 1, 2, 9, 4, 7};

//        waveArray(arr);
//        printArray(arr);
        waveArray(b);
        printArray(b);
        waveArraySorted(b);
        printArray(b);

    }
    static void printArray(int a[]){
        for(int e: a){
            System.out.print(e+" ");
        }
        System.out.println();
    }

//    Sorting
    static void waveArraySorted(int a[]){
        Arrays.sort(a);
        int n = a.length;
        for(int i = 1; i < n; i += 2){
            swap(a,i,i-1);
        }
    }

//    Without sorting
    static void waveArray(int a[]){
        int n = a.length;
        for(int i = 1; i < n ; i += 2){
            if(a[i] > a[i-1]){
                swap(a,i,i-1);
            }
            if(i < n - 1 && a[i] > a[i+1]){
                swap(a,i,i+1);
            }
        }
    }
    static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
