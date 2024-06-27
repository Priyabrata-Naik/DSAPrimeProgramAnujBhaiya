package priorityQueueAndDisjointSets.session_2;

import java.util.Collections;
import java.util.PriorityQueue;

public class LearningPriorityQueue {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> rPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rPq = new PriorityQueue<>((a, b) -> b-a);

        pq.add(10);
        pq.add(40);
        pq.add(5);
        pq.add(80);
        pq.add(50);
        pq.add(100);

        rPq.addAll(pq);

//        By default PriorityQueue implements minHeap in Java
        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq);
//        Works as maxHeap
        System.out.println(rPq);

    }
}
