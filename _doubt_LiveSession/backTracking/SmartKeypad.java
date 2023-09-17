package _doubt_LiveSession.backTracking;

import java.util.ArrayList;
import java.util.List;

public class SmartKeypad {
    public static void main(String[] args) {
        String s = "23";
        List<String> ans = smartKeypad(s);

        for(String e: ans){
            System.out.println(e);
        }
    }
    static List<String> smartKeypad(String input){
        List<String> ans = new ArrayList<>();
        String a[] = {
                "",
                "",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };

        smartKeypadHelper(input,ans,0,a,"");

        return ans;
    }
    static void smartKeypadHelper(String input,List<String> ans,int index,String a[],String cur){
        if(index == input.length()){
            ans.add(cur);
            return;
        }
//        Ascii value of 2 is 50 & 0 is 48 which returns 2 in array
        String present = a[input.charAt(index)-'0'];
        for(int i = 0; i < present.length(); i++){
//            Using backTracking
//            cur = cur + present.charAt(i);
//            smartKeypadHelper(input,ans,index+1,a,cur);
//            cur = cur.substring(0,cur.length()-1);
            smartKeypadHelper(input,ans,index+1,a,cur+present.charAt(i));
        }
    }
}
