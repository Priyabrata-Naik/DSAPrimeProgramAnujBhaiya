package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {

        String s = "aab";
        PalindromePartitioning a = new PalindromePartitioning();
        List<List<String>> ans = a.partition(s);

        for(List<String> e: ans){
            for(String d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
    public List<List<String>> partition(String s)
    {
        //You can code here
        List<List<String>> ans = new ArrayList<>();

        partitionHelper(ans,s,new ArrayList<>(),0);

        return ans;
    }
    void partitionHelper(List<List<String>> ans, String s, List<String> res, int index){
        if(index == s.length()){
            List<String> copyCur = new ArrayList<>(res);
            ans.add(copyCur);
            return;
        }
        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s,index,i)){
                res.add(s.substring(index,i+1));
                partitionHelper(ans,s,res,i+1);
                res.remove(res.size()-1);
            }
        }
    }
    boolean isPalindrome(String s,int l, int r){
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
