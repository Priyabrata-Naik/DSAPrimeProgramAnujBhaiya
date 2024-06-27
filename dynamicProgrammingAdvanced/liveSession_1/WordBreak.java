package dynamicProgrammingAdvanced.liveSession_1;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("i");
        set.add("like");
        set.add("sam");
        set.add("sung");
        set.add("samsung");
        set.add("ice");

        String s = "ilikesamsung";

        boolean ans = wordBreak(s, set);

        System.out.println(ans);
        System.out.println(wordBreakBottomUp(s, set));

    }

    static boolean wordBreakBottomUp(String s, Set<String> set) {
        int n = s.length();
        boolean dp[] = new boolean[n];

        for(int j = 0; j < n; j++){
            for(int i = j; i >= 0; i--){
                String cur = s.substring(i, j+1);
                if(set.contains(cur)){
                    if(i == 0){
                        dp[j] = true;
                        break;
                    }
                    if(dp[i-1]){
                        dp[j] = true;
                        break;
                    }
                }
            }
        }
        return dp[n-1];
    }

    static boolean wordBreak(String s, Set<String> set){
        int n = s.length();
        Boolean dp[] = new Boolean[n];
        return wordBreakUtil(s, set, 0, dp);
    }

    static boolean wordBreakUtil(String s, Set<String> set, int i, Boolean dp[]) {
        int n = s.length();
        if(i == n) return true;

        if(dp[i] != null) return dp[i];

        for(int j = i; j < n; j++) {
            String cur = s.substring(i, j+1);
            if(set.contains(cur)) {
                if(wordBreakUtil(s, set, j+1, dp)) return dp[i] = true;
            }
        }
        return dp[i] = false;
    }
}
