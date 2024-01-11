package stack.session_1;

public class ImplementationOfStackUsingLinkedList {
    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

//        while(!stack.isEmpty()){
//            System.out.print(stack.pop()+" ");
//        }
//        System.out.println();
        stack.push(5);

        System.out.println(stack.peek());
        stack.printStack(stack.head);

    }
}
