package binarySearchTree.session_5;

public class AVLTree {
    public static void main(String[] args) {

        Node root = insertAVL(null, 20);
        root = insertAVL(root, 15);
        root = insertAVL(root, 10);
        root = insertAVL(root, 30);
        root = insertAVL(root, 5);

        printInorder(root);

    }
    static Node leftRotate(Node x){
        Node y = x.right;
        Node A = y.left;

        y.left = x;
        x.right = A;

        x.height = height(x);
        y.height = height(y);

        return y;
    }

    static Node rightRotate(Node x){
        Node y = x.left;
        Node A = y.right;

        y.right = x;
        x.left = A;

        x.height = height(x);
        y.height = height(y);

        return y;
    }

    static int height(Node a){
        if(a == null) return 0;
        int leftHeight = a.left == null ? 0 : a.left.height;
        int rightHeight = a.right == null ? 0 : a.right.height;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static Node insertAVL(Node root, int key){
        if(root == null){
            return new Node(key);
        }

        if(root.data < key){
            root.right = insertAVL(root.right, key);
        }else if(root.data > key){
            root.left = insertAVL(root.left, key);
        }else{
            return root;
        }

        root.height = height(root);
        int hb = height(root.left) - height(root.right);

//        Left-Left case
        if(hb > 1 && key < root.left.data){
            return rightRotate(root);
        }
//        Right-Right case
        if(hb < -1 && key > root.right.data){
            return leftRotate(root);
        }
//        Left-Right case
        if(hb > 1 && key > root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
//        Right-Left case
        if(hb < -1 && key < root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }
    static void printInorder(Node root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
}

class Node {
    int data, height;
    Node left, right;
    public Node(int data){
        this.data = data;
    }
}
