package ab_questionInCourse.dsaArray;

import java.util.Arrays;
import java.util.Vector;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 4,6};
        Vector<Integer> v = findNumbers(a);

        System.out.println(v);

    }
//    Need missing Number logic
    static Vector<Integer> findNumbers(int a[]){

        Vector<Integer> ans = new Vector<>();
        if(a.length == 0) return ans;
        Arrays.sort(a);
        int num = 1;
        int n = a.length;
        int stepCount = 0;

        for(int i = 0; i < n; i++){
            if(a[i] == num && stepCount + a[0] == num){
                num++;
//                stepCount++;
            }else{
                if(i > 0 && a[i] == a[i-1]){
                    ans.add(a[i]);
                    num = a[i];
                    num++;
                    continue;
                }else if(a[i] != num && stepCount+a[0] != num){
                    ans.add(num);
//                    stepCount++;
                    num = a[i];
                }
            }
            int missingNumber = stepCount + a[0];

            stepCount++;
        }
        return ans;

//        Vector<Integer> ans = new Vector<>();
//        if(a.length == 0) return ans;
//        int missingNo = -1;
//        int repeatingNo = -1;
//        Arrays.sort(a);
//        int n = a.length;
//        for(int i = 1; i < n ; i++){
//
//            int count = 0;
//            for(int j = 0; j < n; j++){
//                if(a[j] == i){
//                    count++;
//                }
//
//                if(count == 2) repeatingNo = i;
//                else if(count == 0) missingNo =i;
//
//                if(missingNo != -1 && repeatingNo != -1)
//                    break;
//
//            }
//        }
//
//        ans.add(missingNo);
//        ans.add(repeatingNo);
//        return ans;


    }
}
