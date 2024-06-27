package binaryTree.liveSession_1;

import java.util.ArrayList;
import java.util.List;

public class NodesAtDistanceAtK {
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


        List<Integer> ans = distanceKFromTarget(root, 5, 2);

        System.out.println(ans);

    }

    static List<Integer> distanceKFromTarget(Node root, int target, int k){
        List<Integer> ans = new ArrayList<>();
        distanceKFromTarget(root, target, k, ans);
        return ans;
    }
//    Return value is the distance of target from root node
    static int distanceKFromTarget(Node root, int target, int k , List<Integer> ans){
        if(root == null) return -1;

        if(root.data == target){
            distanceKDown(root, k, ans);
            return 0;
        }
//        dl-> distance of left node from target, if -1, then node not found
        int dl = distanceKFromTarget(root.left, target, k, ans);
        if(dl != -1){
            if(dl + 1 == k){
                ans.add(root.data);
            }
            distanceKDown(root.right, k-dl-2, ans);
            return dl+1;
        }
//        dr-> distance of right node from target, if -1, then node not found
        int dr = distanceKFromTarget(root.right, target, k, ans);
        if(dr != -1){
            if(dr + 1 == k){
                ans.add(root.data);
            }
            distanceKDown(root.left, k-dr-2, ans);
            return dr+1;
        }
        return -1;
    }

    static void distanceKDown(Node root, int k, List<Integer> ans) {
        if(root == null || k < 0) return;
        if(k == 0){
            ans.add(root.data);
            return;
        }
        distanceKDown(root.left, k-1, ans);
        distanceKDown(root.right, k-1, ans);
    }
}
