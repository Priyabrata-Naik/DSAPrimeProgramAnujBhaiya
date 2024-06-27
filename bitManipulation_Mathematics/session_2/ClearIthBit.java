package bitManipulation_Mathematics.session_2;

public class ClearIthBit {
    public static void main(String[] args) {

        int n = 13;
        int i = 2;
        int res = clearIthBit(n,i);

        System.out.println(res);

    }
    static int clearIthBit(int n, int i){
        int mask = ~(1 << i);
        return n & mask;
    }
}
