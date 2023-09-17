package a_dsaPrimeDoubtNPractice.backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "abbaca";
        List<List<String>> ans = palindromicPartitioning(s);
        for(List<String> e: ans){
            for(String d: e){
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }
    static List<List<String>> palindromicPartitioning(String s){
        List<List<String>> ans = new ArrayList<>();
        palindromicHelper(s,ans,0,new ArrayList<>());
        return ans;
    }
    static void palindromicHelper(String s,List<List<String>> ans,int index,List<String> cur){
        if(index == s.length()){
            List<String> copyCur = new ArrayList<>(cur);
            ans.add(copyCur);
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                cur.add(s.substring(index,i+1));
                palindromicHelper(s,ans,i+1,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s,int l, int r){
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
