package backTracking.backTrackingLiveSession2;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArrayTrying {
    public static void main(String[] args) {

        int a[] = { 1, 2, 3};
        List<List<Integer>> ans = subsequenceArray(a);

        for(List<Integer> e: ans){
            System.out.println(e);
        }

    }
//    Logic can be implemented but technique I wanted to use is not in this code(first method)
    static List<List<Integer>> subsequenceArray(int a[]){
        List<List<Integer>> ans = new ArrayList<>();
        subsequenceHelper(a,0,ans,new ArrayList<>());
        return ans;
    }
    static void subsequenceHelper(int a[], int index,List<List<Integer>> ans,List<Integer> cur){
        if(index == a.length){
            List<Integer> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = index; i < a.length; i++){
            cur.add(a[i]);
            subsequenceHelper(a,i+1,ans,cur);
            cur.remove(cur.size()-1);
        }
    }
}
