package dynamicProgrammingBasics.session_5;

import static dynamicProgrammingBasics.session_5.MInOperationToConvertS1ToS2.lcsBottomUp;

public class LongestPalindromicSubSequence {
    public static void main(String[] args) {

        String s = "abdcbtap";

        int ans = longestPalindromicSubsequence(s);

        System.out.println(ans);

    }
    static int longestPalindromicSubsequence(String s){
        int n = s.length();
        char temp[] = new char[n];

        for(int i = n-1; i >= 0; i--){
            temp[n-i-1] = s.charAt(i);
        }

        String s2 = new String(temp);
        return lcsBottomUp(s, s2);
    }
}
