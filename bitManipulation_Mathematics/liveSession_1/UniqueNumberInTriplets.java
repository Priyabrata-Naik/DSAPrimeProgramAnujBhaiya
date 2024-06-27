package bitManipulation_Mathematics.liveSession_1;

public class UniqueNumberInTriplets {
    public static void main(String[] args) {

        int a[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
        int res = uniqueII(a);

        System.out.println(res);

    }
//    T(n) = O(n^2)
    static int uniqueNumber(int a[]){
        int n = a.length;
        int res = -1;

        for(int i = 0; i < n; i++){
            boolean unique = true;
            for(int j = 0; j < n; j++){
                if(i != j && a[i] == a[j]){
                    unique = false;
                    break;
                }
            }
            if(unique){
                res = a[i];
            }
        }
        return res;
    }
    static int uniqueII(int a[]){
        int res = 0;

        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int e: a){
                if((e & (1 << i)) != 0){
                    count++;
                }
            }
            if(count % 3 != 0){
                res = res | (1 << i);
            }
        }
        return res;
    }
}
