package array.sortingAlgo;

public class SelectionSort {

    public static void main(String[] args) {

        int a[] = { 0, 5, 8, 1, 2, 1002 };

        selectionSort(a);

        for (int e : a) {
            System.out.print(e + " ");
        }

    }

    static void selectionSort(int a[]) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (a[minIndex] > a[j]) {
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

}
