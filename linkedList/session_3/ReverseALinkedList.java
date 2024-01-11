package linkedList.session_3;

public class ReverseALinkedList {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(3);
        Node<Integer> n3 = new Node<>(4);
        Node<Integer> n4 = new Node<>(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
//        Node<Integer> newHead = reverseLinkedList(head);
//        printLinkedList(newHead);
        Node<Integer> rsNewHead = reverseLLRecursively(head);
        System.out.println("Recursive LinkedList: ");
        printLinkedList(rsNewHead);

    }
    static Node<Integer> reverseLLRecursively(Node<Integer> head){
        if(head == null || head.next == null) return head;

        Node<Integer> headOfSubProblem = reverseLLRecursively(head.next);

        head.next.next = head;
        head.next = null;

        return headOfSubProblem;
    }
    static Node<Integer> reverseLinkedList(Node<Integer> head){
        if(head == null || head.next == null) return head;
        Node<Integer> prev = head;
        Node<Integer> cur = head.next;
        head.next = null;

        while(cur != null){
            Node<Integer> next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    static void printLinkedList(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Node<E>{
    E data;
    Node<E> next;

    public Node(E data){
        this.data = data;
    }
}
