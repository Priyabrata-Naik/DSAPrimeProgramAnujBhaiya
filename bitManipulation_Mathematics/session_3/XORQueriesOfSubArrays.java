package bitManipulation_Mathematics.session_3;

public class XORQueriesOfSubArrays {
    public static void main(String[] args) {

        int a[] = {1, 3, 4, 8};
        int l = 0;
        int r = 3;
        int res = xorQueries(a,l,r);

        System.out.println(res);

    }
//    NEED TO BE SOLVED ACCORDING TO SESSION QUESTION
    static int xorQueries(int a[], int l, int r){
        int n = a.length;
        int xor[] = new int[n];
        xor[0] = a[0];
        for(int i = 1; i < n; i++){
            xor[i] = xor[i-1] ^ a[i];
        }
        int left = l == 0? 0:xor[l-1];
        int right = xor[r];
        return left ^ right;
    }
//    DON'T KNOW HOW TO IMPLEMENT IT FOR THE GIVEN QUESTION IN SESSION
    static int[] xorQueriesOp(int a[], int q[]){
//        IMPLEMENTATION IS PENDING
        return new int[2];
    }
}
