package binaryTree.session_1;

public class MinimumInABinaryTree {
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

//        int ans = minimumInTree(root);
        int ans = height(root);

        System.out.println(ans);

    }
    static int height(Node root){
        if(root == null) return 0;
        int hl = height(root.left);
        int hr = height(root.right);
        return Math.max(hl, hr) + 1;
    }
    static int minimumInTree(Node root){
        if(root == null) return Integer.MAX_VALUE;
        int minFromLeft = minimumInTree(root.left);
        int minFromRight = minimumInTree(root.right);
        return Math.min(Math.min(minFromRight,minFromLeft), root.data);
    }
}

