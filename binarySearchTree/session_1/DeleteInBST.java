package binarySearchTree.session_1;

public class DeleteInBST {
    public static void main(String[] args) {

        Node n1 = new Node(8);
        Node n2 = new Node(3);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        Node n5 = new Node(6);
        Node n6 = new Node(14);
        Node n7 = new Node(4);
        Node n8 = new Node(7);

        Node root = n1;
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n5.left = n7;
        n5.right = n8;

        printInorder(root);
        System.out.println();
        root = delete(root, 3);
        printInorder(root);

    }
    static Node delete(Node root, int key){
        if(root == null) return null;
        if(root.data > key){
            root.left = delete(root.left, key);
        }else if(root.data < key){
            root.right = delete(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            Node inorderSuc = findSmallest(root.right);
            root.data = inorderSuc.data;

            root.right = delete(root.right, inorderSuc.data);
        }
        return root;
    }
    static Node findSmallest(Node root){
        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }
    static void printInorder(Node root){
        if(root == null) return;
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }
}
