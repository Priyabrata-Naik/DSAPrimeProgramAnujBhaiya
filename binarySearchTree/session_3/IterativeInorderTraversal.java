package binarySearchTree.session_3;

import java.util.ArrayDeque;

public class IterativeInorderTraversal {
    public static void main(String[] args) {

        Node n1 = new Node(8);
        Node n2 = new Node(3);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        Node n5 = new Node(6);
        Node n6 = new Node(14);
        Node n7 = new Node(4);
        Node n8 = new Node(7);

        Node root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;

        printInorderIterative(root);

    }
    static void printInorderIterative(Node root){
        if(root == null) return;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        Node cur = root;

        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            Node pop = stack.pop();
            System.out.print(pop.data+" ");
            cur = pop.right;
        }
    }
}

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
    }
}
