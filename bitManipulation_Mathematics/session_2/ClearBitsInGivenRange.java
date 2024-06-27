package bitManipulation_Mathematics.session_2;

public class ClearBitsInGivenRange {
    public static void main(String[] args) {

        int n = 13;
        int i = 1;
        int j = 3;
        int res = clearBitsInGivenRange(n,i,j);

        System.out.println(res);

    }
    static int clearBitsInGivenRange(int n, int i, int j){
        int a = (~0 << (j+1));
        int b = (1 << i)-1;
        int mask = a|b;
        return n & mask;
    }
}
