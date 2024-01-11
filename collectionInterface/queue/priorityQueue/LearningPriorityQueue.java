package collectionInterface.queue.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class LearningPriorityQueue {
    public static void main(String[] args) {

        Queue<Integer> pq = new PriorityQueue<>();

        pq.offer(40);
        pq.offer(30);
        pq.offer(10);
        pq.offer(20);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq);

        Queue<Integer> cpq = new PriorityQueue<>((a,b) -> b - a);

        cpq.offer(4);
        cpq.offer(6);
        cpq.offer(60);
        cpq.offer(-6);

        System.out.println(cpq);
        System.out.println(cpq.poll());
        System.out.println(cpq.poll());
        System.out.println(cpq);

    }
}
