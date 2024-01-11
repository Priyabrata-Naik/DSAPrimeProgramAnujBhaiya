package ab_questionInCourse.backTracking;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfGivenArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(1);
        a.add(1);
        ArrayList<ArrayList<Integer>> ans = AllSubsets(a);
        for(ArrayList<Integer> e: ans){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }
    }
    public static ArrayList<ArrayList<Integer>> AllSubsets(ArrayList<Integer> nums) {

        //You can code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        AllSubsetsHelper(nums,ans,0,new ArrayList<>());
        return ans;
    }
    static void AllSubsetsHelper(ArrayList<Integer> nums,ArrayList<ArrayList<Integer>> ans,int index, ArrayList<Integer> res){
        ArrayList<Integer> copyCur = new ArrayList<>(res);
        ans.add(copyCur);
        for(int i = index; i < nums.size(); i++){
            if(i > index && nums.get(i) == nums.get(i-1))continue;
            res.add(nums.get(i));
            AllSubsetsHelper(nums,ans,i+1,res);
            res.remove(res.size()-1);
        }
    }
}
