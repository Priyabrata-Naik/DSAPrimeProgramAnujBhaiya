package binaryTree.session_5;

public class LowestCommonAncestor {
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

        Node ans = lowestCommonAncestor(root, 6, 4);

        System.out.println(ans.data);

    }
    static Node lowestCommonAncestor(Node root, int a, int b){
         if(root == null) return null;
         if(root.data == a || root.data == b) return root;

         Node left = lowestCommonAncestor(root.left, a, b);
         Node right = lowestCommonAncestor(root.right, a, b);

         if(left == null) return right;
         if(right == null) return left;

         return root;
    }
}
