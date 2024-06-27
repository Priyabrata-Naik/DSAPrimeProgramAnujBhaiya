package stringAlgorithms_Trie.session_3;

import java.util.ArrayList;

public class SortSetOfStringsLexicographically {
    public static void main(String[] args) {

        String s = "any apple shark new fast";

        ArrayList<String> ans = sortStrings(s.split(" "));

        System.out.println(ans);
    }

    static ArrayList<String> sortStrings(String a[]){
        ArrayList<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for(String s: a) trie.insert(s);
//        sortStringsHelper(trie, trie.root, new StringBuilder(), ans);
        sortStringsHelper(trie, trie.root, ans);

        return ans;
    }

    static void sortStringsHelper(Trie trie, Trie.TrieNode node, StringBuilder cur, ArrayList<String> ans){
        if(node == null) return;
        if(node.isEnd){
            ans.add(cur.toString());
        }

        for(int i = 0; i < trie.LETTERS_COUNT; i++){
            if(node.children[i] != null){
                cur.append((char) ('a'+ i));
                sortStringsHelper(trie, node.children[i], cur, ans);
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }

    static void sortStringsHelper(Trie trie, Trie.TrieNode node, ArrayList<String> ans){
        if(node == null) return;
        if(node.stored != null){
            ans.add(node.stored);
        }

        for(int i = 0; i < trie.LETTERS_COUNT; i++){
            if(node.children[i] != null){
                sortStringsHelper(trie, node.children[i], ans);
            }
        }
    }
}


