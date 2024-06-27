package binaryTree.session_1;

public class CreatingBinaryTree {
    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(9);
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        Node n5 = new Node(6);
        Node n6 = new Node(8);

        Node root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);

    }
    static void inorder(Node root){
        if(root == null)return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void preorder(Node root){
        if(root == null)return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(Node root){
        if(root == null)return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
}
class Node{
    int data;
    Node left,right;
    public Node(int data){
        this.data = data;
    }
}
