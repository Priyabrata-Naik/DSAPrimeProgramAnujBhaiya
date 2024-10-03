package dsaArray.session_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumDifferenceArrayLocation {
    public static void main(String[] args) {

        int a[] = {12, 9, 8, 2, 11};

        List<List<Integer>> ans = minDifferencePointerByMe(a);
        List<List<Integer>> res = minDifferencePointerOp(a);

        System.out.println(res);
        System.out.println(ans);

    }
    //    This returns unsorted array
    static List<List<Integer>> minDifferencePointerByMe(int a[]){
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int bigNumber = Math.max(a[i],a[j]);
                int smallNumber = Math.min(a[i],a[j]);
                if(min > bigNumber - Math.abs(smallNumber)){
                    min = bigNumber - Math.abs(smallNumber);
                }
            }
        }
//        System.out.println(min);
        for(int i = 0; i < n-1; i++){
            List<Integer> res = new ArrayList<>();
            for(int j = i+1; j < n; j++){
                int bigNumber = Math.max(a[i],a[j]);
                int smallNumber = Math.min(a[i],a[j]);
                if(min == bigNumber - Math.abs(smallNumber)){
                    res.add(a[j]);
                    res.add(a[i]);
                    ans.add(res);
                }
            }

        }

        Collections.sort(ans, (o1, o2) -> {
            return o1.get(0) - o2.get(0);
        });

        return ans;
    }
    //    This returns sorted order
    static List<List<Integer>> minDifferencePointerOp(int a[]){
        int n = a.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(a);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 1; i < n; i++){
            if(minDiff > a[i] - Math.abs(a[i-1])){
                minDiff = a[i] - Math.abs(a[i-1]);
            }
        }
        for(int i = 1; i < n; i++){
            int value = Math.abs(a[i-1]);
            if(minDiff == a[i] - value){
                List<Integer> res = new ArrayList<>();
                res.add(a[i-1]);
                res.add(a[i]);
                ans.add(res);
            }
        }
        return ans;
    }
}
