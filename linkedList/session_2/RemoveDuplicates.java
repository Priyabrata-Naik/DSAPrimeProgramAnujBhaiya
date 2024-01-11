package linkedList.session_2;

public class RemoveDuplicates {
    public static void main(String[] args) {

        Node<Integer> head = new Node<>(1);
        Node<Integer> n1 = new Node<>(2);
        Node<Integer> n2 = new Node<>(2);
        Node<Integer> n3 = new Node<>(4);
        Node<Integer> n4 = new Node<>(4);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(head);
        Node<Integer> newHead = removeDuplicates(head);

        printLinkedList(newHead);

    }
    static Node<Integer> removeDuplicates(Node<Integer> head){
        Node<Integer> temp = head;
        Node<Integer> orig = head;
        Node<Integer> newHead = null;

        while(orig != null){
            while(orig.next != null && orig.data == orig.next.data){
                orig = orig.next;
            }
            if(newHead == null){
                newHead = temp = orig;
            }else {
                temp.next = orig;
                temp = orig;
            }
            orig = orig.next;
        }
        return newHead;
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
