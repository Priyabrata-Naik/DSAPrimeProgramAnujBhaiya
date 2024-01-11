package ab_questionInCourse.backTracking;

import java.util.*;

public class PermutationOfStringByMe {
    public static void main(String[] args) {
        String s = "RRMRR";
        List<String> ans = permute(s);
        for(String e: ans){
            System.out.println(e);
        }
    }
    public static List<String> permute(String str) {
        List<String> ans = new ArrayList<>();
        permuteHelper(str,ans,"",0);
        Collections.sort(ans);
        return ans;
    }
    static void permuteHelper(String s,List<String> ans,String cur,int l){
        if(l == s.length()){
            if(!ans.contains(s)){
                ans.add(s);
            }
            return;
        }
        for(int i = l; i < s.length(); i++){
            if(i > l && s.charAt(i) == s.charAt(i-1))continue;
            String res = swap(s,l,i);
            permuteHelper(res,ans,cur,l+1);
            res = swap(s,l,i);
        }
    }

    private static String swap(String s, int l, int r) {
        char c[] = s.toCharArray();
        char temp = c[l];
        c[l] = c[r];
        c[r] = temp;
        String resultString = new String(c);
        return resultString;
    }
}
