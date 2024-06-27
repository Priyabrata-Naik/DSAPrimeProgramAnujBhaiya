package binarySearchTree.liveSession_1;

public class MinAbsoluteDifferenceInBST {
    public static void main(String[] args) {

        Node n1 = new Node(8); Node n2 = new Node(4);
        Node n3 = new Node(10); Node n4 = new Node(1);
        Node n5 = new Node(6); Node n6 = new Node(14);
        Node n7 = new Node(7);

        Node root = n1; n1.left = n2;
        n1.right = n3; n2.left = n4;
        n2.right = n5; n3.right = n6;
        n5.right = n7;

        System.out.println(minAbsDiffInBST(root));

    }
    static int ans = Integer.MAX_VALUE;
    static Node prev = null;
    static int minAbsDiffInBST(Node root){
        minAbsDiffInBSTUtil(root);
        return ans;
    }
    static void minAbsDiffInBSTUtil(Node root){
        if(root == null) return;

        minAbsDiffInBSTUtil(root.left);
        if(prev != null){
            ans = Math.min(ans, root.data - prev.data);
        }
        prev = root;
        minAbsDiffInBSTUtil(root.right);
    }
}
