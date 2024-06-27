package binaryTree.session_2;

public class CousinsInBinaryTree {
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

        boolean ans = areCousins(root, 2, 3);

        System.out.println(ans);

    }
    static Node xPar, yPar;
    static int xLevel, yLevel;
    static void areCousinsHelper(Node node, Node par, int x, int y, int level){
        if(node == null) return;
        if(node.data == x){
            xPar = par;
            xLevel = level;
        }
        if(node.data == y){
            yPar = par;
            yLevel = level;
        }
        areCousinsHelper(node.left, node, x, y, level + 1);
        areCousinsHelper(node.right, node, x, y, level + 1);
    }
    static boolean areCousins(Node root, int x, int y){
        areCousinsHelper(root, null, x, y, 0);
        boolean parLevel = xLevel == yLevel;
        boolean diffPar = xPar != yPar;
        return parLevel && diffPar;
    }
}
class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
    }
}
