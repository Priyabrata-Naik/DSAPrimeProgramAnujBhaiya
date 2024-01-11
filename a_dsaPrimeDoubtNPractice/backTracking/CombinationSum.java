package a_dsaPrimeDoubtNPractice.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int a[] = {8, 1, 3, 7, 2, 1, 5};
        int sum = 12;
        List<List<Integer>> ans = combinationSum(a,sum);

        for(List<Integer> e: ans){
            System.out.println(e);
        }
    }
    static List<List<Integer>> combinationSum(int a[], int sum){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        helper(a,ans,0,new ArrayList<>(),sum);
        return ans;
    }
    static void helper(int a[],List<List<Integer>> ans,int index, List<Integer> cur,int sum){
        if(sum == 0){
            List<Integer> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = index; i < a.length; i++){
            if(a[i] > sum) return;
            if(i > index && a[i] == a[i-1]) continue;
            cur.add(a[i]);
//            sum = sum - a[i];
//            System.out.println(sum);
//            helper(a,ans,i+1,cur,sum);
            helper(a,ans,i+1,cur,sum - a[i]);
            cur.remove(cur.size()-1);
        }
    }
}
