package linkedList.session_2;

public class FindTheMiddleNode {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(2);
        Node<Integer> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(1);
        Node<Integer> n3 = new Node<>(8);
        Node<Integer> n4 = new Node<>(6);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
        Node<Integer> ans = getMiddleNodeOp(head);
//        System.out.println(getMiddleNode(head));
        System.out.println(ans.data);

    }
    static Node<Integer> getMiddleNodeOp(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
//    BUILT OWN LOGIC BY UNDERSTANDING
    static Node<Integer> getMiddleNode(Node<Integer> head){
        Node<Integer> temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }
        int jump = count>>1;
        count = 0;
        Node<Integer> middleNode = head;

        while(count < jump){
            middleNode = middleNode.next;
            count++;
        }
        return middleNode;
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
        this.next = null;
    }
}
