package stringAlgorithms_Trie.liveSession_1;

import java.util.ArrayList;

public class RabinKarpAlgorithm {
    public static void main(String[] args) {

        String s = "abcdefcd";
        String p = "cd";

        ArrayList<Integer> ans = rabinKarpMatching(s, p);

        System.out.println(ans);

    }

    static final int CHAR_SIZE = 26;
    static final int M = (int) 1e7 + 7;

    static ArrayList<Integer> rabinKarpMatching(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(m > n) return ans;

        int hp = rollingHash(p, m);
        int hs = rollingHash(s, m);

        for(int i = m; i < n; i++){
            if(hp == hs){
                if(isExactMatch(s, p, i-m)){
                    ans.add(i-m);
                }
            }
            hs -= (int) ((Math.pow(CHAR_SIZE, m-1) % M * s.charAt(i-m)) % M);
            hs *= CHAR_SIZE;
            hs += s.charAt(i);
        }

        if(hp == hs){
            if(isExactMatch(s, p, n-m))
                ans.add(n-m);
        }

        return ans;
    }

    static boolean isExactMatch(String s, String p, int ind){
        for(int i = 0; i < p.length(); i++){
            if(s.charAt(i+ind) != p.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static int rollingHash(String s, int size) {
        int hash = 0;

        for(int i = 0; i < size; i++){
            hash += (int) ((Math.pow(CHAR_SIZE, size-i-1) % M * s.charAt(i)) % M);
        }
        return hash;
    }
}
