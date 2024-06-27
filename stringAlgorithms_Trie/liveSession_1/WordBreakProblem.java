package stringAlgorithms_Trie.liveSession_1;

public class WordBreakProblem {
    public static void main(String[] args) {

        String a[] = {"this", "is", "word", "problem", "break"};
        String s = "thisproblembreak";

        boolean ans = wordBreakUsingTrie(a, s);

        System.out.println(ans);

    }

    static boolean wordBreakUsingTrie(String a[], String s) {
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        Trie trie = new Trie();
        for(String e: a) trie.insert(e);

        for(int i = 0; i < n; i++){
            if(dp[i]){
                Trie.TrieNode node = trie.root;
                for(int j = i; j < n; j++){
                    if(node == null) break;
                    node = node.children[s.charAt(j) - 'a'];
                    if(node != null && node.isEnd)
                        dp[j+1] = true;
                }
            }
        }
        return dp[n];
    }
}

class Trie{
    final int LETTERS_COUNT = 26;

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[LETTERS_COUNT];
        boolean isEnd;
        String stored;
    }

    public void insert(String s){
        TrieNode temp = root;

        for(int i = 0; i < s.length(); i++){
            int curPos = s.charAt(i) - 'a';
            if(temp.children[curPos] == null){
                temp.children[curPos] = new TrieNode();
            }
            temp = temp.children[curPos];
        }
        temp.isEnd = true;
        temp.stored = s;
    }

    public boolean search(String s){
        TrieNode temp = root;

        for(int i = 0; i < s.length(); i++){
            int curPos = s.charAt(i) - 'a';
            if(temp.children[curPos] == null) return false;
            temp = temp.children[curPos];
        }
        return temp.isEnd;
    }

}