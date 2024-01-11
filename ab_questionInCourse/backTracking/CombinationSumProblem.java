package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumProblem {
    public static void main(String[] args) {

        int a[] = {3, 9, 8, 7, 5};
        int arr[] = {8, 1, 3, 7, 2, 1, 5};
        int t = 14;
        int target = 12;
        CombinationSumProblem obj = new CombinationSumProblem();
        List<List<Integer>> ans = obj.combinationSum2(arr,target);

        for(List<Integer> e: ans){
            System.out.println(e);
        }

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        //You can code here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);

        helper(candidates,target,ans,0,new ArrayList<>());
        return ans;
    }
    void helper(int a[],int target,List<List<Integer>> ans,int index,List<Integer> res){

        if(target == 0){
            List<Integer> copyCur = new ArrayList<>(res);
            ans.add(copyCur);
            return;
        }

        for(int i = index; i < a.length; i++){
            if(a[i] > target) return;
            if(i > index && a[i] == a[i-1]) continue;
            target -= a[i];
            res.add(a[i]);
            helper(a,target,ans,i+1,res);
            res.remove(res.size()-1);
            target+= a[i];
        }

    }
}
