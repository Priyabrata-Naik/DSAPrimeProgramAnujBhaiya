package binarySearchTree.liveSession_1;

public class RecoverBST {
    public static void main(String[] args) {

        Node n1 = new Node(8); Node n2 = new Node(4);
        Node n3 = new Node(6); Node n4 = new Node(1);
        Node n5 = new Node(10); Node n6 = new Node(14);
        Node n7 = new Node(7);

        Node root = n1; n1.left = n2;
        n1.right = n3; n2.left = n4;
        n2.right = n5; n3.right = n6;
        n5.right = n7;

        inorder(root);
        System.out.println();
        recoverBST(root);
        inorder(root);
        System.out.println();

    }
    static Node left, mid, right;
    static void recoverBST(Node root){
        recoverBSTUtil(root, null);
        if(left != null && right != null){
            swapNodes(left, right);
        }
        if(left != null && right == null){
            swapNodes(left, mid);
        }
    }
    static void recoverBSTUtil(Node root, Node prev){
        if(root == null) return;

        recoverBSTUtil(root.left, prev);

        if(prev != null){
            if(prev.data > root.data){
                if(left == null){
                    left = prev;
                    mid = root;
                }else{
                    right = root;
                    return;
                }
            }
        }
        prev = root;
        recoverBSTUtil(root.right, prev);
    }
    static void swapNodes(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
