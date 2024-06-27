package bitManipulation_Mathematics.session_2;

public class SetIthBit {
    public static void main(String[] args) {

        int n = 9;
        int i = 2;
        int res = setIthBit(n,i);

        System.out.println(res);

    }
    static int setIthBit(int n, int i){
        int mask = 1 << i;
        return (n|mask);
    }
}
