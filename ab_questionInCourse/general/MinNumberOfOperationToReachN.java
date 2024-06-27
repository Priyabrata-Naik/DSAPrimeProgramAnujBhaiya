package ab_questionInCourse.general;

import java.util.Scanner;

public class MinNumberOfOperationToReachN {
    public static void main(String[] args) {

        int n = 11;
        int ans = minOperationToReachNAns(n);
        int res = minOperationToReachN(n);

        System.out.println(ans);
        System.out.println(res);

    }
    static int minOperationToReachN(int n){
        int count = 0;
        int temp = 0;

        while(temp <= n){
            if(temp == 0){
                temp += 1;
                count++;
            }else if((temp << 1) <= n){
                temp <<= 1;
                count++;
            }else if(temp < n){
                temp += 1;
                count++;
            }else{
                return count;
            }
            System.out.println(temp+" -> " + count);
        }
        return 0;
    }
//    Wrong Output
    static int minOperationToReachNAns(int n){
//        if(n == 0){
//            return 0;
//        }
        int k = 1;
        while(n != 1){
            if(n % 2 == 0){
                n = n / 2;
                k++;
            }else{
                n = n -1;
                k++;
            }
        }
        return k;
    }
}
