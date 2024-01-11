package queues.session_2;

public class ImplementStackUsingOneQueue {
    public static void main(String[] args) {

        StackUsingOneQueue stack = new StackUsingOneQueue();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println(stack.pop());
        System.out.println(stack.pop()
        );

    }
}
