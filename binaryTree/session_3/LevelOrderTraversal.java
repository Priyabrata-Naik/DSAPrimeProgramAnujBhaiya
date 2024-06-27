package binaryTree.session_3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
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

        ArrayList<ArrayList<Integer>> ans = levelOrderTraversal3(root);

        System.out.println(ans);

    }
    static ArrayList<Integer> levelOrderTraversal(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            Node cur = q.poll();
            ans.add(cur.data);
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
        }
        return ans;
    }
    static ArrayList<ArrayList<Integer>> levelOrderTraversal2(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        ArrayList<Integer> curList = new ArrayList<>();

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur == null){
                ans.add(curList);
                if(q.isEmpty()) break;
                curList = new ArrayList<>();
                q.add(null);
            }else{
                curList.add(cur.data);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
        }
        return ans;
    }
    static ArrayList<ArrayList<Integer>> levelOrderTraversal3(Node root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> curList = new ArrayList<>();

            for(int i = 0; i < n; i++){
                Node cur = q.poll();
                curList.add(cur.data);
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
            }
            ans.add(curList);
        }
        return ans;
    }
}
