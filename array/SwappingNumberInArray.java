package array;

public class SwappingNumberInArray {

    public static void main(String[] args) {

        int a[] = { 14, 40, 80, 50, -10 };
//		int i = 1;
//		int j = 4;

//		int res[] = swapNumber(a, i, j);
//		for (int e : res) {
//			System.out.print(e + " ");
//		}
        int ans = smallestNumberInArray(a);

        System.out.println(ans);

    }

    static int[] swapNumber(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }

    static int smallestNumberInArray(int a[]) {
        if (a.length == 0) {
            return Integer.MIN_VALUE;
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }

}
