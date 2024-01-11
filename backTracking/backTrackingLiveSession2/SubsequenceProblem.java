package backTracking.backTrackingLiveSession2;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceProblem {
    public static void main(String[] args) {

        int a[] = {4,4, 5, 6};
        List<List<Integer>> ans = subsequence(a);

        for(List<Integer> e: ans){
            System.out.println(e);
        }

    }
    static List<List<Integer>> subsequence(int a[]){
        List<List<Integer>> ans = new ArrayList<>();
        subsequenceHelper(a,ans,0,new ArrayList<>());
        return ans;
    }
    static void subsequenceHelper(int a[],List<List<Integer>> ans, int index, List<Integer> cur){
        List<Integer> copyCur = new ArrayList<>(cur);
        ans.add(copyCur);

        for(int i = index; i < a.length; i++){
            if(i > index && a[i] == a[i-1])continue;
            cur.add(a[i]);
            subsequenceHelper(a,ans,i+1,cur);
            cur.remove(cur.size()-1);
        }
    }
}

