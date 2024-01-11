package ab_questionInCourse.backTracking;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermutationOfString {
    public static void main(String[] args) {
        String s = "ABC";
        List<String> ans = permute(s);
        for(String e: ans){
            System.out.println(e);
        }
    }
    public static List<String> permute(String str) {
        //You can code here
            List<String> ans = new ArrayList<>();
            permuteHelper(ans, str, "", 0, str.length() - 1);
            Collections.sort(ans);
            return ans;
        }
        public static void permuteHelper (List < String > ans, String str, String cur,int l, int r){

            // if( str.charAt(l) == str.charAt(r) && l == r){
            //   ans.add(str);
            //   return;
            // }
            if (l == str.length()) {
                ans.add(str);
                return;
            }

            for (int i = l; i <= r; i++) {
                if (i > l && str.charAt(i) == str.charAt(i - 1)) continue;
                String res = swap(str, l, i);
                permuteHelper(ans, res, cur, l + 1, r);
                res = swap(str, l, i);
            }

        }
        static String swap (String str,int i, int l){
            char s[] = str.toCharArray();
            char temp = s[i];
            s[i] = s[l];
            s[l] = temp;
            String resultString = new String(s);
            return resultString;
        }

}
