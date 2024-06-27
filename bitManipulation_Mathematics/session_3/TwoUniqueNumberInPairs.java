package bitManipulation_Mathematics.session_3;

public class TwoUniqueNumberInPairs {
    public static void main(String[] args) {

//        int a[] = {1, 2, 5, 2, 1};
//        int res = findOneNonRepeatingElement(a);
//
//        System.out.println(res);

        int a[] = {1, 2, 3, 6, 2, 1};
        int res[] = twoUniqueElement(a);

        for(int e: res){
            System.out.print(e+" ");
        }

    }
    static int findOneNonRepeatingElement(int a[]){
        int res = 0;
        int n = a.length;
        for(int i = 0; i < n; i++){
            res ^= a[i];
        }
        return res;
    }
    static int[] twoUniqueElement(int a[]){
        int xor = 0;
        for(int e: a){
            xor ^= e;
        }
        int mask = xor & (-xor);
        int firstNumber = 0;
        for(int e: a){
            if((mask & e) == 0){
                firstNumber ^= e;
            }
        }
        int secondNumber = xor ^ firstNumber;
        int ans[] = {firstNumber,secondNumber};
        return ans;
    }
}
