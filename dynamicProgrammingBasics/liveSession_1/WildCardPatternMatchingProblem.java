package dynamicProgrammingBasics.liveSession_1;

public class WildCardPatternMatchingProblem {
    public static void main(String[] args) {

        String txt = "baaabab";
        String pat = "****ba***ab**";

        boolean ans = wildCardMatchingProblem(txt, pat);

        System.out.println(ans);

    }

    static boolean wildCardMatchingProblem(String txt, String pat){
        int m = txt.length();
        int n = pat.length();
        Boolean dp[][] = new Boolean[m][n];
        return wildCardMatchingProblemUtil(txt, pat, m-1, n-1, dp);
    }

    static boolean wildCardMatchingProblemUtil(String txt, String pat, int i, int j, Boolean dp[][]){
        if(i == -1){
            for(int k = j; k >= 0; k--){
                if(pat.charAt(k) != '*') return false;
            }
            return true;
        }
        if(j == -1) return false;

        if(dp[i][j] != null) return dp[i][j];

        if(txt.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?'){
            return dp[i][j] = wildCardMatchingProblemUtil(txt, pat, i-1, j-1, dp);
        }

        if(pat.charAt(j) == '*'){
            return dp[i][j] = wildCardMatchingProblemUtil(txt, pat, i-1, j, dp) ||
                    wildCardMatchingProblemUtil(txt, pat, i, j-1, dp);
        }

        return false;
    }
}
