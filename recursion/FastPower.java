package recursion;

public class FastPower {

    public static void main(String[] args) {

        System.out.println(fastPower(2, 10));

    }

    static long fastPower(int a, int b) {
        long res = 1;

//		while (b > 0) {
//			if ((b & 1) == 1) {
//				res *= a;
//			}
//			a *= a;
//			b >>= 1;
//		}
        for (int i = b; i > 0; i = i >> 1) {
            if ((i & 1) == 1) {
                res *= a;
            }
            a *= a;
        }

        return res;
    }

}
