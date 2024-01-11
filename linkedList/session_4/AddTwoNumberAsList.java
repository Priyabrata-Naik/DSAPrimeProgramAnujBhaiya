package linkedList.session_4;

public class AddTwoNumberAsList {
    public static void main(String[] args) {

        Node l1 = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);

        l1.next = n1;
        n1.next = n2;

        Node l2 = new Node(9);
        Node m1 = new Node(4);

        l2.next = m1;

        printLinkedList(l1);
        printLinkedList(l2);
        Node newHead = addTwoLinkedList(l1,l2);
        printLinkedList(newHead);

    }
    static Node addTwoLinkedList(Node l1, Node l2){
        Node r1 = reverseLinkedList(l1);
        Node r2 = reverseLinkedList(l2);
        int carry = 0;
        Node ans = null;
        Node temp = null;

        while(r1 != null || r2 != null || carry != 0){
            int sum = carry;
            if(r1 != null){
                sum += r1.data;
                r1 = r1.next;
            }
            if(r2 != null){
                sum += r2.data;
                r2 = r2.next;
            }
            int digit = sum % 10;
            carry = sum / 10;
            Node newNode = new Node(digit);
            if(ans == null){
                ans = temp = newNode;
            }else {
                temp.next = newNode;
                temp = newNode;
            }
        }
        return reverseLinkedList(ans);
    }
    static Node reverseLinkedList(Node head){
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
    static void printLinkedList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}
