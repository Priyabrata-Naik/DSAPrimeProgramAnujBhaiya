package bitManipulation_Mathematics.session_3;

public class ClearLastSetBit {
    public static void main(String[] args) {

        int n = 26;
        int res = clearLastSetBitOp(n);

        System.out.println(res);

    }
//    O(n) = logn
    static int clearLastSetBit(int n){
        int temp = n;
        int count = 0;
        while((temp&1) != 1){
            count++;
            temp = temp>>1;
        }
        int mask = ~(1 << count);
        return n & mask;
    }
    static int clearLastSetBitOp(int n){
        return n & (n-1);

    }
}
