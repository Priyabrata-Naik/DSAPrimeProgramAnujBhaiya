package binaryTree.session_4;

import java.util.*;

public class TopViewOfTree {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        Node root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;
        n3.right = n5;

        ArrayList<Integer> ans = topViewOfTree(root);

        System.out.println(ans);

    }
    static ArrayList<Integer> topViewOfTree(Node root){
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            map.putIfAbsent(cur.hd, cur.node.data);

            if(cur.node.left != null){
                q.add(new Pair(cur.hd-1, cur.node.left));
            }
            if(cur.node.right != null){
                q.add(new Pair(cur.hd+1, cur.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }
}
