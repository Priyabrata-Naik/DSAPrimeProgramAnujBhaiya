package binaryTree.session_4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);

        System.out.println(ans);

    }
    static ArrayList<ArrayList<Integer>> verticalOrderTraversal(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(new Pair(0, root));

        while(!q.isEmpty()){
            Pair cur = q.poll();
            if(!map.containsKey(cur.hd)){
                map.put(cur.hd, new ArrayList<>());
            }
            map.get(cur.hd).add(cur.node.data);
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
class Node{
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
class Pair{
    int hd;
    Node node;

    public Pair(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}
