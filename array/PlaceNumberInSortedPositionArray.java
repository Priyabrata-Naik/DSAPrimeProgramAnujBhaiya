package array;

public class PlaceNumberInSortedPositionArray {

    public static void main(String[] args) {

        int a[] = { 1, 3, 4, 5, 8, -12 };
//		int res[] = sortLastElement(a);
//
//		for (int ans : res) {
//			System.out.print(ans + " ");
//		}

        sortElementInSortedArray(a);

        for (int e : a) {
            System.out.print(e + " ");
        }

    }

    static int[] sortLastElement(int a[]) {
        if (a.length == 0) {
            return a;
        }
        int last = a.length - 1;
        for (int i = last - 1; i >= 0; i--) {
            if (a[i] > a[last]) {
                int temp = a[last];
                a[i + 1] = a[i];
                a[i] = temp;
                last = i;
            }
        }
        return a;

    }

    static void sortElementInSortedArray(int a[]) {
        int n = a.length;
        int last = a[n - 1];
        int swapIndex = n - 2;

        while (swapIndex >= 0 && a[swapIndex] > last) {
            swapIndex--;
        }
        for (int i = n - 1; i >= swapIndex + 2; i--) {
            a[i] = a[i - 1];
        }
        a[swapIndex + 1] = last;
    }

}
