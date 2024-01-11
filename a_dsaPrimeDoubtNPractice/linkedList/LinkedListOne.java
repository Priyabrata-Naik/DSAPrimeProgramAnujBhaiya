package a_dsaPrimeDoubtNPractice.linkedList;

public class LinkedListOne {
    public static void main(String[] args) {
        Node<Integer> head= new Node<>(1);

        Node<Integer> n1= new Node<>(2);
        Node<Integer> n2= new Node<>(5);
        Node<Integer> n3= new Node<>(8);

        head.next= n1;
        n1.next= n2;
        n2.next=n3;

        printLinkedList(head);

        insertInLinkedList(2,4,head);

        System.out.println(head);



    }

    public static void printLinkedList(Node<Integer> head){
        Node<Integer> temp= head;
        while (temp !=null){
            System.out.print(temp.val+" ->");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node<Integer> insertInLinkedList(int pos,int data,Node<Integer> head){
        Node<Integer> newNode = new Node<>(data);
        if(pos==0){
            newNode.next=head;
            return newNode;
        }
        Node<Integer> temp = head;
        for (int i =0;i<pos-1;i++){
            temp = temp.next;

        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }
}
class Node <E> {
    E val;
    Node<E> next;


    public Node(E val) {
        this.val = val;
        this.next = null;
    }
}
