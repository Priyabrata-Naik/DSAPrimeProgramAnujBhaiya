package binaryTree.session_5;

public class DistanceBetweenTwoNodes {
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

        int a = 8;
        int b = 7;

        int ans = distanceBtnTwoNodes(root, a, b);
        int ans2 = distanceBtnTwoNodes2(root, a, b);

        System.out.println(ans);
        System.out.println(ans2);

    }
    static int distanceBtnTwoNodes(Node root, int a, int b){
        Node lca = lowestCommonAncestor(root, a, b);
        Integer distanceA = distance(root, a);
        Integer distanceB = distance(root, b);
        Integer distanceLca = distance(root, lca.data);
        return distanceA + distanceB - 2 * distanceLca;
    }
    static int distanceBtnTwoNodes2(Node root, int a, int b){
        Node lca = lowestCommonAncestor(root, a, b);
        return distance(lca, a) + distance(lca, b);
    }
    static Integer distance(Node root, int a){
        if(root == null) return null;
        if(root.data == a) return 0;

        Integer left = distance(root.left, a);
        Integer right = distance(root.right, a);

        if(left == null && right == null) return null;
        if(left == null) return right+1;
        if(right == null) return left+1;

        return null;
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
