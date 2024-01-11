package collectionInterface.queue.deque.arrayDeque;

import java.util.ArrayDeque;

public class StackAndQueueOperationInArrayDeque {
    public static void main(String[] args) {

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(43);
        stack.push(20);
        stack.push(90);
        stack.push(50);

        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.peek());
        System.out.println(stack);

        ArrayDeque<Integer> q = new ArrayDeque<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);

        System.out.println(q);
        System.out.println(q.poll());
        System.out.println(q.poll());

        System.out.println(q.peek());
        System.out.println(q);

    }
}
