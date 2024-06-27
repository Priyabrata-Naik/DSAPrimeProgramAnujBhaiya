package bitManipulation_Mathematics.session_2;

public class GetIthBit {
    public static void main(String[] args) {

        int n = 9;
        int i = 3;

        int res = getIthBit(n,i);

        System.out.println(res);

    }
    static int getIthBit(int n , int i){
        int mask = 1 << i;
        int res = (n & mask);

        if(res == 0){
            return 0;
        }
        return 1;
    }
}
