package dynamicProgrammingBasics.session_5;

import static dynamicProgrammingBasics.session_5.MInOperationToConvertS1ToS2.lcsBottomUp;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {

        String a = "AGGTAB";
        String b = "GXTXAYB";

        int ans = shortestCommonSuperSequence(a, b);

        System.out.println(ans);

    }
    static int shortestCommonSuperSequence(String s1, String s2){
        int lcs = lcsBottomUp(s1, s2);
        return s1.length() + s2.length() - lcs;
    }
}
