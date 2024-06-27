package ab_questionInCourse.dsaArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegersContainingOnly_1_2_3 {
    public static void main(String[] args) {

        int a[] = {321, 4312, 132, 123};
        List<Integer> res = find123DigitsOp(a,a.length);

        System.out.println(res);

    }
    public static List<Integer> find123DigitsByMe(int[] arr, int n)
    {
        //You can code here
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int temp = arr[i];
            while(temp > 0){
                if(temp % 10 == 1){
                    count1++;
                }else if(temp % 10 == 2){
                    count2++;
                }else if(temp % 10 == 3){
                    count3++;
                }
                temp /= 10;
                if(temp == 0 && count1 >= 1 && count2 >= 1 && count3 >= 1){
                    ans.add(arr[i]);
                }
            }
        }
        if(ans.isEmpty()){
            ans.add(-1);
            return ans;
        }

        Collections.sort(ans);

        return ans;
    }
    static List<Integer> find123DigitsOp(int[] arr, int n){
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int temp = arr[i];
            boolean one = false, two = false, three = false;

            while(temp > 0){
                int remainder = temp % 10;
                if(remainder == 1) one = true;
                if(remainder == 2) two = true;
                if(remainder == 3) three = true;
                temp /= 10;
            }
            if(one && two && three) ans.add(arr[i]);
        }
        if(ans.isEmpty()){
            ans.add(-1);
            return ans;
        }
        Collections.sort(ans);

        return ans;
    }
}
