package backTracking.backTrackingLiveSession2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSumProblem {
    public static void main(String[] args) {
        int a[] = {8, 1, 3, 7, 2, 1, 5};
        int sum = 12;
//        int a[] = {1, 1, 1, 1};
//        int sum = 2;
        List<List<Integer>> ans = combinationSum(a,sum);

//        Arrays.sort(a);
//        for(int e: a){
//            System.out.print(e+" ");
//        }

        for(List<Integer> e: ans){
            System.out.println(e);
        }
//        String s = "aab";
//        List<List<String>> ans = palindromicPartitioning(s);
//
//        for(List<String> e: ans){
//            System.out.println(e);
//        }

    }
    static List<List<String>> palindromicPartitioning(String s){
        List<List<String>> ans = new ArrayList<>();
        palindromicHelper(s,0,s.length()-1,ans,new ArrayList<>());
        return ans;
    }
    static void palindromicHelper(String s,int l, int r, List<List<String>> ans, List<String> cur){
        if(l > r){
            List<String> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = l; i < s.length(); i++){
            if(isPalindrome(s,l,i)){
                cur.add(s.substring(l,i+1));
                palindromicHelper(s,l+1,r,ans,cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while(l <= r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    static List<List<Integer>> combinationSum(int a[],int sum){
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
//            helper(a,ans,i+1,cur,sum);
            helper(a,ans,i+1,cur,sum - a[i]);
            cur.remove(cur.size()-1);
        }
    }
}
