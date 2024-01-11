package linkedList.session_1;

public class LearningLinkedList {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(4);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(8);
        Node<Integer> n3 = new Node<>(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        printLinkedList(head);

        Node<Integer> ans = insertInLinkedList(0,10,head);
        deleteFromLinkedList(2, ans);

        printLinkedList(ans);
    }
    static Node<Integer> deleteFromLinkedList(int pos, Node<Integer> head){
        Node<Integer> temp = head;
        if(pos == 0){
            return head.next;
        }
        for(int i = 0; i < pos-1; i++){
            temp = temp.next;
        }
//        Node<Integer> toDelete = temp.next;
        temp.next = temp.next.next;

        return head;
    }
    static void printLinkedList(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            System.out.print(temp.val+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    static Node<Integer> insertInLinkedList(int pos, int data, Node<Integer> head){
        Node<Integer> newNode = new Node<>(data);
        Node<Integer> temp = head;
        if(pos == 0){
            newNode.next = head;
            head = newNode;
            return head;
        }

        for(int i = 0; i < pos-1; i++){
            temp = temp.next;
//            System.out.println(temp.val);
        }
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }
}

class Node<E>{
    E val;
    Node<E> next;

    public  Node(E val){
        this.val = val;
        this.next = null;
    }
}
