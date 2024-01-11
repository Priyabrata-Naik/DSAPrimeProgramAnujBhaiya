package stack.session_1;

public class ImplementationOfStackUsingArrays {
    public static void main(String[] args) {

        StackUsingArrays stack = new StackUsingArrays(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        stack.printStack();
        stack.push(6);
        stack.printStack();

        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.printStack();

    }
}
