package stringAlgorithms_Trie.session_3;

public class LongestCommonPrefixForSetOfString {
    public static void main(String[] args) {

        String s = "app apple apply";

        String ans = longestCommonPrefix(s.split(" "));

        System.out.println(ans);

    }

    static String longestCommonPrefix(String a[]){
        StringBuilder sb = new StringBuilder();

        Trie trie = new Trie();

        for (String s : a) {
            trie.insert(s);
        }

        Trie.TrieNode temp = trie.root;

        while(!temp.isEnd){
            int count = 0;
            int nextChildIndex = -1;

            for(int i = 0; i < trie.LETTERS_COUNT; i++){
                if(temp.children[i] != null){
                    nextChildIndex = i;
                    count++;
                }
            }
            if(count == 1){
                sb.append((char) ('a'+nextChildIndex));
                temp = temp.children[nextChildIndex];
            }else{
                break;
            }
        }
        return sb.toString();
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
