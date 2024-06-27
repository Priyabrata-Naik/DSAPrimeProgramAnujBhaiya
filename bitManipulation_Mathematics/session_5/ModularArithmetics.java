package bitManipulation_Mathematics.session_5;

public class ModularArithmetics {
    public static void main(String[] args) {

//        int a = 3;
//        int b = 4;
//        int res = fastPowerM(a, b);
//
//        System.out.println(res);
//        System.out.println(fact(5));
        System.out.println(nCrM(5,3));

    }
    static int m = (int) (1e9+7);
    static int addM(int a, int b){
        return (a%m + b%m) % m;
    }
    static int mulM(int a, int b){
        return (int)((long)a%m * (long)b%m) % m;
    }
    static int subM(int a, int b){
        return (a%m - b%m + m) % m;
    }
    static int fastPowerM(int a, int b){
        int res = 1;
        while(b > 0){
            if((b&1) != 0){
//                res = (res%m * a%m) % m;
                res = mulM(res, a);
            }
//            a = (a%m * a%m) % m;
            a = mulM(a,a);
            b = b >> 1;
        }
        return res;
    }
    static int inv(int a){
        return fastPowerM(a,m-2);
    }
    static int divM(int a, int b){
//        return (a%m * fastPowerM(b,m-2)%m) % m;
//        return mulM(a,fastPowerM(b,m-2));
        return mulM(a,inv(b));
    }
    static int factM(int n){
        int res = 1;
        for(int i = 1; i <= n; i++){
            res = mulM(res,i);
        }
        return res;
    }
    static int nCrM(int n, int r){
        return mulM(mulM(factM(n), inv(factM(n-r))), inv(factM(r)));
    }
}
