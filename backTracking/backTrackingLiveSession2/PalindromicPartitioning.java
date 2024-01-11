package backTracking.backTrackingLiveSession2;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = palindromicPartitioning(s);

        for(List<String> e: ans){
            System.out.println(e);
        }
    }
    static List<List<String>> palindromicPartitioning(String s){
        List<List<String>> ans = new ArrayList<>();
        palindromicHelper(s,0,ans,new ArrayList<>());
        return ans;
    }
    static void palindromicHelper(String s,int l, List<List<String>> ans, List<String> cur){
        if(l == s.length()){
            List<String> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = l; i < s.length(); i++){
            if(isPalindrome(s,l,i)){
                cur.add(s.substring(l,i+1));
                palindromicHelper(s,i+1,ans,cur);
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
}
