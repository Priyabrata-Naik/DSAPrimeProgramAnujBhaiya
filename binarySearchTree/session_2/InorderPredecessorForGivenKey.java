package binarySearchTree.session_2;

public class InorderPredecessorForGivenKey {
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

        Node pred = inorderPredecessor(root, 6, null);

        printInorder(root);
        System.out.println();
        if(pred == null){
            System.out.println("Predecessor not found");
        }else{
            System.out.println(pred.data);
        }

    }
    static Node inorderPredecessor(Node root, int key, Node predecessor){
        if(root == null) return null;
        if(root.data > key){
            return inorderPredecessor(root.left, key, predecessor);
        }else if(root.data < key){
            predecessor = root;
            return inorderPredecessor(root.right, key, predecessor);
        }else{
            if(root.left == null){
                return predecessor;
            }else{
                return getMax(root.left);
            }
        }
    }
    static Node getMax(Node root){
        while(root.right != null){
            root = root.right;
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
