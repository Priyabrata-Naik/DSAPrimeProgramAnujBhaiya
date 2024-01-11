package dsaArray.session_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[] args) {

//        int a[] = {4, 3, 1, -1, 5, 8, 6,-7};
        int arr[] = {4, 2, 2, 2, 1, 1, 1, -1, -3, 0, 1, 2, 3, 3, 3};
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length-2; i++){
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            List<List<Integer>> cur = twoSum(arr,-arr[i],i+1);
            for(List<Integer> e: cur){
                e.add(0,arr[i]);
                ans.add(e);
            }
        }
        System.out.println(ans);

    }
    static List<List<Integer>> twoSum(int[] a, int sum, int startFrom){
        List<List<Integer>> ans = new ArrayList<>();

        int l = startFrom;
        int r = a.length-1;

        while(l < r){
            if(l > 0 && a[l] == a[l-1]) {
                l++;
                continue;
            }

            if(r < a.length - 1 && a[r] == a[r+1]){
                r--;
                continue;
            }

            if(a[l] + a[r] > sum){
                r--;
            }else if(a[l]+a[r] < sum){
                l++;
            }else{
                List<Integer> res = new ArrayList<>();
                res.add(a[l]);
                res.add(a[r]);
                ans.add(res);
                l++;
                r--;
            }
        }
        return ans;
    }
}
