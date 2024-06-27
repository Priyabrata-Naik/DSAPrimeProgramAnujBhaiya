package stringAlgorithms_Trie.liveSession_1;

import java.util.ArrayList;

public class FindDuplicateRows {
    public static void main(String[] args) {

        int a[][] = {
                {0, 0, 1},
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        };

        System.out.println(findDuplicateRows(a));

    }

    static ArrayList<Integer> findDuplicateRows(int a[][]) {
        int n = a.length;
        int m = a[0].length;
        ArrayList<Integer> ans = new ArrayList<>();
        Node head = new Node();

        for(int i = 0; i < n; i++){
            Node node = head;
            for(int j = 0; j < m; j++){
                if(a[i][j] == 0){
                    if(node.zero == null)
                        node.zero = new Node();
                    node = node.zero;
                }else{
                    if(node.one == null)
                        node.one = new Node();
                    node = node.one;
                }
            }
            if(node.isEnd){
                ans.add(i);
            }
            node.isEnd = true;
        }
        return ans;
    }

    static class Node {
        Node zero, one;
        boolean isEnd;
    }
}
