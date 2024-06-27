package stringAlgorithms_Trie.session_1;

import java.util.ArrayList;

public class KMPAlgorithm {
    public static void main(String[] args) {

        String s = "ABCDABC";
        String p = "ABC";

        ArrayList<Integer> ans = kmpStringMatching(s, p);

        System.out.println(ans);

    }

    static ArrayList<Integer> kmpStringMatching(String s, String p){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m > n) return ans;
        int lps[] = generateLPS(p);
        int i = 0, j = 0;

        while(i < n){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
                if(j == m){
                    ans.add(i-m);
                    j = lps[j-1];
                }
            }else{
                if(j == 0) i++;
                else{
                    j = lps[j-1];
                }
            }
        }
        return ans;
    }

    static int[] generateLPS(String S){
        int m = S.length();
        int lps[] = new int[m];
        int p = 0, s = 1;

        while(s < m){
            if(S.charAt(p) == S.charAt(s)){
                lps[s] = p + 1;
                p++;
                s++;
            }else{
                if(p == 0) s++;
                else{
                    p = lps[p-1];
                }
            }
        }
        return lps;
    }
}
