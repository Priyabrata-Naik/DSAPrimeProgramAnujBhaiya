package bitManipulation_Mathematics.session_3;

public class CountSetBits {
    public static void main(String[] args) {

        int n = 14;
        int res = countSetBitsOp(n);

        System.out.println(res);

    }
    static int countSetBitsOp(int n){
        int count = 0;
        while(n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    static int countSetBits(int n){
        int count = 0;
        while(n != 0){
            if((n & 1) != 0){
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
