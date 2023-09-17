package aa_problemOfTheDay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringSwapDoubt_PermutationOfString {
    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = permute(s);

        System.out.println(ans);
    }
//    Need edge case optimization
    public static List<String> permute(String str) {

        //You can code here
        List<String> ls = new ArrayList<>();
        permuteHelper(ls,str,"",0,str.length()-1);
        Collections.sort(ls);
        return ls;
    }
    public static void permuteHelper(List<String> ans,String str,String cur,int l,int r){


        if(l == r){
            ans.add(str);
            return ;
        }

        for(int i = l; i <= r; i++){
            String res = swap(str,l,i);
            permuteHelper(ans,res,cur,l+1,r);
            res = swap(str,l,i);
        }

    }
    static String swap(String str,int i,int l){
        char s[] = str.toCharArray();
        char temp = s[i];
        s[i] = s[l];
        s[l] = temp;
        return new String(s);
    }
}
