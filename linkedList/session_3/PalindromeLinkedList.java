package linkedList.session_3;

public class PalindromeLinkedList {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(3);
        Node<Integer> n3 = new Node<>(2);
        Node<Integer> n4 = new Node<>(1);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
        System.out.println(isLLPalindrome(head));

    }
    static boolean isLLPalindrome(Node<Integer> head){
        Node<Integer> middle = findMiddle(head);
        Node<Integer> t2 = reverseLinkedList(middle);
        Node<Integer> t1 = head;

        while(t2 != null){
            if(t1.data != t2.data){
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
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
    static Node<Integer> findMiddle(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static void printLinkedList(Node<Integer> head){
        Node<Integer> temp = head;

        while(temp != null){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
}
