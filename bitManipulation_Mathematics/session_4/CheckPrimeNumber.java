package bitManipulation_Mathematics.session_4;

public class CheckPrimeNumber {
    public static void main(String[] args) {

        int n = 7;
        boolean ans = checkPrime(n);

        System.out.println(ans);

    }
    static boolean checkPrime(int n){

        for(int i = 2; i * i <= n; i++){
            if((n%i) == 0){
                return false;
            }
        }
        return true;
    }
}
