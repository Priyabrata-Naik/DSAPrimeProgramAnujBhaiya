package collectionInterface.queue.deque;

import java.util.ArrayDeque;

public class LearningDeque {
    public static void main(String[] args) {

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        dq.offer(10);
        dq.offerLast(20);
        dq.offerFirst(30);
        dq.offerFirst(40);

        System.out.println(dq);

        System.out.println(dq.poll());
        System.out.println(dq.pollLast());

        System.out.println(dq);

        System.out.println(dq.peek());
        System.out.println(dq.peekLast());

    }
}
