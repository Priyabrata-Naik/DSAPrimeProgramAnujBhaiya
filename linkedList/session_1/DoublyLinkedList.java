package linkedList.session_1;

public class DoublyLinkedList {
    public static void main(String[] args) {

        DoubleLinkedListNode<Integer> head = new DoubleLinkedListNode<>(5);
        DoubleLinkedListNode<Integer> n1 = new DoubleLinkedListNode<>(2);
        DoubleLinkedListNode<Integer> n2 = new DoubleLinkedListNode<>(8);
        DoubleLinkedListNode<Integer> n3 = new DoubleLinkedListNode<>(1);

        head.next = n1;
        n1.prev = head;

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        printLinkedList(head);
        DoubleLinkedListNode<Integer> newHead = insertInLinkedList(2,10,head);
        deleteFromLinkedList(3,newHead);

        printLinkedList(newHead);

    }
    static DoubleLinkedListNode<Integer> deleteFromLinkedList(int pos, DoubleLinkedListNode<Integer> head){
        DoubleLinkedListNode<Integer> temp = head;

        if(pos == 0){
            head = head.next;
            head.prev = null;
            return head;
        }

        for(int i = 0; i < pos-1; i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        if(temp.next.next != null){
            temp.next.next.prev = temp;
        }

        return head;
    }
    static void printLinkedList(DoubleLinkedListNode<Integer> head){
        DoubleLinkedListNode<Integer> temp = head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    static DoubleLinkedListNode<Integer> insertInLinkedList(int pos, int data, DoubleLinkedListNode<Integer> head){
        DoubleLinkedListNode<Integer> temp = head;
        DoubleLinkedListNode<Integer> toAdd = new DoubleLinkedListNode<>(data);

        if(pos == 0){
            toAdd.next = head;
            head.prev = toAdd;
            return toAdd;
        }

        for(int i = 0; i < pos-1; i++){
            temp = temp.next;
        }

        toAdd.next = temp.next;
        temp.next.prev = toAdd;

        temp.next = toAdd;
        toAdd.prev = temp;

        return head;
    }
}

class DoubleLinkedListNode<E>{
    E data;
    DoubleLinkedListNode<E> next,prev;

    public DoubleLinkedListNode(E data){
        this.data = data;
        this.next = this.prev = null;
    }

}
