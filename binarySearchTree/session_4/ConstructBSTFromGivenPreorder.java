package binarySearchTree.session_4;

public class ConstructBSTFromGivenPreorder {
    public static void main(String[] args) {

        int a[] = {8, 5, 1, 7, 10, 12};
        Node root = constructBSTFromPreorder(a, 0, a.length-1);

        inorder(root);

    }
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static Node constructBSTFromPreorder(int a[], int l, int r){
        if(l > r) return null;
        Node root = new Node(a[l]);
        int i = l+1;
        for(; i <= r; i++){
            if(a[l] < a[i]) break;
        }
        root.left = constructBSTFromPreorder(a, l+1, i-1);
        root.right = constructBSTFromPreorder(a, i, r);
        return root;
    }
}
