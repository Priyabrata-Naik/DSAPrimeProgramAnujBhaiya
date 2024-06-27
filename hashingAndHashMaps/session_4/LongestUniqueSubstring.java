package hashingAndHashMaps.session_4;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static void main(String[] args) {

        String s = "abcabcbb";
        int ans = longestUniqueSubstring(s);

        System.out.println(ans);

    }
    static int longestUniqueSubstring(String s){
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;

        while(r < n){
            if(!map.containsKey(s.charAt(r)) || map.get(s.charAt(r)) < l){
                ans = Math.max(ans, r - l + 1);
            }else{
                l = map.get(s.charAt(r)) + 1;
            }
            map.put(s.charAt(r), r);
            r++;
        }
        return ans;
    }
}
