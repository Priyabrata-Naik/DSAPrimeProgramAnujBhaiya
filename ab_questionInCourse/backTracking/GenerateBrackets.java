package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBrackets {
    public static void main(String[] args) {
        int a = 3;
        List<String> ans= AllParenthesis(a);
        for(String e: ans){
            System.out.print(e+" ");
        }
    }
    public static List<String> AllParenthesis(int n) {
        //You can code here
        List<String> ans = new ArrayList<>();
        helper(n,0,0,0,ans,"");
        return ans;
    }
    static void helper(int n,int i,int open, int close,List<String> ans,String cur){
        if(i == 2 * n){
            ans.add(cur);
            return;
        }
        if(open < n){
            cur = cur + '(';
            helper(n,i+1,open+1,close,ans,cur);
            cur = cur.substring(0,cur.length()-1);
        }
        if(close < open){
            cur = cur + ')';
            helper(n,i+1,open,close+1,ans,cur);
        }
    }
}
