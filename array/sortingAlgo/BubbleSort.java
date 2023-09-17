package array.sortingAlgo;

public class BubbleSort {

    public static void main(String[] args) {

        int a[] = { 5, 8, 10, 4, 3, 1 };

        bubbleSort(a);

        for (int e : a) {
            System.out.print(e + " ");
        }

    }

    static void bubbleSort(int a[]) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }
    }

}
