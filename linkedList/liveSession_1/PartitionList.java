package linkedList.liveSession_1;

public class PartitionList {
    public static void main(String[] args) {

        int b = 3;
        Node head = new Node(1);
        Node n1 = new Node(4);
        Node n2 = new Node(3);
        Node n3 = new Node(2);
        Node n4 = new Node(5);
        Node n5 = new Node(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printLinkedList(head);
        Node newList = partitionList(head,b);
        printLinkedList(newList);

    }
    static Node partitionList(Node head, int b){
        if(head == null || head.next == null) return head;
        Node cur = head;
        Node sHead = new Node(-1);
        Node lHead = new Node(-1);

        Node sTail = sHead;
        Node lTail = lHead;

        while(cur != null){
            if(cur.data < b){
                sTail.next = cur;
                sTail = cur;
            }else{
                lTail.next = cur;
                lTail = cur;
            }
            cur = cur.next;
        }
        sTail.next = lHead.next;
        lTail.next = null;

        return sHead.next;
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
    Node next,prev;

    public Node(int data){
        this.data = data;
    }
}
