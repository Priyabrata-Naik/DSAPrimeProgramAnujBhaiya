package a_dsaPrimeDoubtNPractice.linkedList;

public class ReverseKLinkedList {
    public static void main(String[] args) {

        SimpleNode head = new SimpleNode(1);
        SimpleNode n1 = new SimpleNode(2);
        SimpleNode n2 = new SimpleNode(3);
        SimpleNode n3 = new SimpleNode(4);
        SimpleNode n4 = new SimpleNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        int k = 3;

        printLL(head);
        SimpleNode reverseLL = reverseLLKGroups(head,k);
        printLL(reverseLL);

    }
    static SimpleNode reverseLLKGroups(SimpleNode head, int k){
        SimpleNode dummy = new SimpleNode(-1);
        SimpleNode prevTail = dummy;
        dummy.next = head;
        SimpleNode curHead = head;

        while (curHead != null) {
            SimpleNode curTail = findTailAfterK(curHead,k);
            if(curTail == null)break;
            SimpleNode nextHead = curTail.next;
            reverseLLForK(curHead,k);
            prevTail.next = curTail;
            prevTail = curHead;
            curHead = nextHead;
        }
        prevTail.next = curHead;
        return dummy.next;
    }
    static SimpleNode findTailAfterK(SimpleNode head, int k){
        for(int i = 0; i < k-1; i++){
            head = head.next;
            if(head == null)return null;
        }
        return head;
    }
    static void reverseLLForK(SimpleNode head, int k){
        SimpleNode cur = head;
        SimpleNode prev = null;
        int count = 0;
        while(count < k && cur != null){
            SimpleNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }
    }
    static void printLL(SimpleNode head){
        SimpleNode temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
class SimpleNode{
    int data;
    SimpleNode next,prev;

    public SimpleNode(int data){
        this.data = data;
        this.next = this.prev = null;
    }
}

