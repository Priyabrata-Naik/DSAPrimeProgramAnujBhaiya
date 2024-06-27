package binaryTree.session_3;


import java.util.ArrayList;

public class PrintRightViewOfBinaryTree {
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

        ArrayList<Integer> ans = new ArrayList<>();

        rightView(root);

    }
    static void rightView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        rightViewHelper(root, 0, ans);
        System.out.println(ans);
    }
    static void rightViewHelper(Node root, int level, ArrayList<Integer> ans){
        if(root == null) return;
        if(level >= ans.size()){
            ans.add(root.data);
        }
        rightViewHelper(root.right, level+1, ans);
        rightViewHelper(root.left, level+1, ans);
    }
}
class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
    }
}
