package binarySearchTree.liveSession_1;

import java.util.ArrayList;

public class PrintBSTElementsInGivenRange {
    public static void main(String[] args) {

        Node n1 = new Node(8); Node n2 = new Node(4);
        Node n3 = new Node(10); Node n4 = new Node(1);
        Node n5 = new Node(6); Node n6 = new Node(14);
        Node n7 = new Node(7);

        Node root = n1; n1.left = n2;
        n1.right = n3; n2.left = n4;
        n2.right = n5; n3.right = n6;
        n5.right = n7;

        System.out.println(printInRange(root, 6, 12));

    }
    static ArrayList<Integer> printInRange(Node root, int low, int high){
        ArrayList<Integer> ans = new ArrayList<>();
        printInRangeUtil(root, low, high, ans);
        return ans;
    }
    static void printInRangeUtil(Node root, int low, int high, ArrayList<Integer> ans){
        if(root == null) return;

        if(root.data > low){
            printInRangeUtil(root.left, low, high, ans);
        }
        if(root.data >= low && root.data <= high){
            ans.add(root.data);
        }
        if(root.data < high){
            printInRangeUtil(root.right, low, high, ans);
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
