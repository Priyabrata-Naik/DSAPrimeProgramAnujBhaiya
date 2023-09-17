package recursion;

public class RecursionMedium {

    public static void main(String[] args) {

        System.out.println(nCr(0, 3));
//		System.out.println(josephus(5, 3));

    }

    static int nCr(int n, int r) {
        if (n == r || r == 0 || n == 0)
            return 1;
        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }

    static int josephus(int n, int k) {
        if (n == 1)
            return 0;
        return ((josephus(n - 1, k) + k) % n);
    }

}
