package ab_questionInCourse.dsaArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

public class MissingAndRepeatingNumber {
    public static void main(String[] args) {

        int a[] = {1, 2, 3, 4, 4, 6};
        Vector<Integer> v = findNumbers(a);

        System.out.println(v);
        System.out.println(findNumbersOp(a));

    }

//    T.C O(N^2), NEED TO OPTIMISE
    static Vector<Integer> findNumbers(int a[]){

        Vector<Integer> ans = new Vector<>();
        int n = a.length;
        if(n == 0) return ans;
        int missingNum = -1, repeatingNum = -1;

        for(int i = 1; i <= n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(a[j] == i){
                    count++;
                }
            }
            if(count == 2) repeatingNum = i;
            else if(count == 0) missingNum = i;
        }

        if(missingNum != -1){
            ans.add(missingNum);
            ans.add(repeatingNum);
        }

        return ans;
    }

    static Vector<Integer> findNumbersOp(int a[]){
        Vector<Integer> ans = new Vector<>();
        int n = a.length;
        int missing = -1, repeating = -1;
        int elementCount[] = new int[n+1];

        for(int i = 0; i < n; i++){
            elementCount[a[i]]++;
        }

        for(int i = 1; i <= n; i++){
            if(elementCount[i] == 2) repeating = i;
            else if(elementCount[i] == 0) missing = i;
        }

        if(missing != -1){
            ans.add(missing);
            ans.add(repeating);
        }

        return ans;

    }

}
