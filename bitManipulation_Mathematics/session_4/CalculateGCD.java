package bitManipulation_Mathematics.session_4;

public class CalculateGCD {
    public static void main(String[] args) {

        int a = 24;
        int b = 36;
        int res = gcd(a,b);

        System.out.println(res);

    }
    static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
