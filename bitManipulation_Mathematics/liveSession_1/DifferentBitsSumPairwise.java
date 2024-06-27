package bitManipulation_Mathematics.liveSession_1;

public class DifferentBitsSumPairwise {
    public static void main(String[] args) {

        int a[] = {1, 3, 5};
        int res = diffBitsSumPairwise(a);

        System.out.println(res);

    }
    static int diffBitsSumPairwise(int a[]){
        int n = a.length;
        int ans = 0;

        for(int i = 0; i < 32; i++){
            int k = 0;
            for(int e: a){
                if((e & (1 << i)) != 0){
                    k++;
                }
            }
            ans += k * (n-k) * 2;
        }
        return ans;
    }
}
