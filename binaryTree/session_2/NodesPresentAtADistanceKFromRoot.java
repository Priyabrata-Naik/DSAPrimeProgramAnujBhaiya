package binaryTree.session_2;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class NodesPresentAtADistanceKFromRoot {
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

//        ArrayList<Integer> ans = new ArrayList<>();
//
//        nodesAtDistanceK(root, 2, ans);

        System.out.println(nodesAtLevelK(root, 2));

    }
    static void nodesAtDistanceK(Node root, int level, ArrayList<Integer> ans){
        if(root == null || level < 0) return;
        if(level == 0){
            ans.add(root.data);
            return;
        }
        nodesAtDistanceK(root.left, level-1, ans);
        nodesAtDistanceK(root.right, level-1, ans);
    }
    static ArrayList<Integer> nodesAtLevelK(Node root, int level){
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Pair> stack = new ArrayDeque<>();

        Pair pair = new Pair(root, level);
        stack.push(pair);

        while(!stack.isEmpty()){
            Pair cur = stack.poll();
            if(cur.node == null) continue;
            if(cur.level == 0){
                ans.add(cur.node.data);
                continue;
            }
            stack.push(new Pair(cur.node.right, cur.level-1));
            stack.push(new Pair(cur.node.left, cur.level-1));
        }

        return ans;
    }
    static class Pair{
        Node node;
        int level;
        public Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
}
