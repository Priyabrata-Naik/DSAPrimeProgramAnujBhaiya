package collectionInterface.queue.linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class BasicOfLLQ {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.add(50);
        q.add(450);
        q.add(250);

        System.out.println(q);
        q.poll();
        System.out.println(q);

    }
}
