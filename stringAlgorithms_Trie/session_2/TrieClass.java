package stringAlgorithms_Trie.session_2;

import java.util.Arrays;

public class TrieClass {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("and");
        trie.insert("ant");
        trie.insert("an");
        trie.insert("dog");
        trie.insert("dio");

        System.out.println(trie.search("dog"));

    }

}

class Trie{
    final int LETTER_COUNT = 26;

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    class TrieNode{
        TrieNode[] children = new TrieNode[LETTER_COUNT];
        boolean isEnd;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "children=" + Arrays.toString(children) +
                    ", isEnd=" + isEnd +
                    '}';
        }
    }

    public void insert(String s){
        TrieNode temp = root;

        for(int i = 0; i < s.length(); i++){
            int curPos = s.charAt(i) - 'a';
            System.out.println("1st temp -> " + temp.children[curPos]);
            if(temp.children[curPos] == null){
                temp.children[curPos] = new TrieNode();
            }
            System.out.println("1st temp after initialization -> " + temp.children[curPos]);
            temp = temp.children[curPos];
            System.out.println("2nd temp -> " + temp.children[curPos]);
        }
        temp.isEnd = true;
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
