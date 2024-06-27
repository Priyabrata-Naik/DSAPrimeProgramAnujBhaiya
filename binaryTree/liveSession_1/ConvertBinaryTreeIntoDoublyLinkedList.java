package binaryTree.liveSession_1;

public class ConvertBinaryTreeIntoDoublyLinkedList {
    public static void main(String[] args) {

        Node n1 = new Node(3); Node n2 = new Node(5);
        Node n3 = new Node(1); Node n4 = new Node(6);
        Node n5 = new Node(2); Node n6 = new Node(0);
        Node n7 = new Node(8); Node n8 = new Node(7);
        Node n9 = new Node(4);

        Node root = n1; n1.left = n2;
        n1.right = n3; n2.left = n4;
        n2.right = n5; n3.left = n6;
        n3.right = n7; n5.left = n8;
        n5.right = n9;

        Node ans = convertBinaryTreeIntoDLL(root);

        while(ans != null){
            System.out.print(ans.data+" ");
            ans = ans.right;
        }

    }
    static Node convertBinaryTreeIntoDLL(Node root){
        if(root == null) return null;
        convertBinaryTreeIntoDDLUtil(root);

        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    static Node convertBinaryTreeIntoDDLUtil(Node root){
        if(root == null) return null;

        if(root.left != null){
            Node leftRoot = convertBinaryTreeIntoDDLUtil(root.left);
            while(leftRoot.right != null){
                leftRoot = leftRoot.right;
            }
            leftRoot.right = root;
            root.left = leftRoot;
        }
        if(root.right != null){
            Node rightRoot = convertBinaryTreeIntoDDLUtil(root.right);
            while(rightRoot.left != null){
                rightRoot = rightRoot.left;
            }
            root.right = rightRoot;
            rightRoot.left = root;
        }
        return root;
    }
}

class Node{
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
    }
}
