package recursion;

public class RecursionSundayClass {

    public static void main(String[] args) {

//		System.out.println(fastPow(2.3, 3));
        System.out.println(fastPower(8, 4, 10));

    }

    static double fastPow(double a, int b) {
        if (b == 0)
            return 1;
        if (b < 0)
            return fastPow(1 / a, Math.abs(b));
        if ((b & 1) == 0) {
            return fastPow(a * a, b >> 1);
        }
        return a * fastPow(a, b - 1);
    }

    static double fastPower(double a, int b, int m) {
        if (b == 0)
            return 1 % m;
        if (b < 0)
            return fastPower(1 / a, Math.abs(b), m);
        if ((b & 1) == 0) {
            return fastPower((a % m * a % m) % m, b >> 1, m);
        }
        return (a % m * fastPower(a, b - 1, m) % m) % m;
    }

}
