package binarySearchTree.session_2;

public class CheckIfATreeIsBST {
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

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;

        System.out.println(isBST(root, min, max));

    }
    static boolean isBST(Node root, int min, int max){
        if(root == null) return true;
        if(root.data < min || root.data > max) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

}
class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
    }
}