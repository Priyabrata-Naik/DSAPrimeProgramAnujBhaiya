package linkedList.session_4;

public class ReorderList {
    public static void main(String[] args) {

        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);
        Node n4 = new Node(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
        Node newHead = reorderLinkedList(head);
        printLinkedList(newHead);

    }
    static Node reorderLinkedList(Node head){
        Node l1 = head;
        Node middle = findMiddle(head);
        Node l2 = reverseLinkedList(middle);

        while(l2 != null){
            if(l1 == l2){
                l1.next = null;
                break;
            }
            Node l1Next = l1.next;
            Node l2Next = l2.next;
            l1.next = l2;
            l2.next = l1Next;


            l1 = l1Next;
            l2 = l2Next;
        }
        return head;
    }
    static Node reverseLinkedList(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = head;
        Node cur = head.next;
        head.next = null;

        while(cur != null){
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    static Node findMiddle(Node head){
        if(head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
