package collectionInterface.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueOperation {
    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);

        System.out.println(q);

//        Iterating a queue
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

//        System.out.println(q.poll());
//
//        System.out.println(q.peek());
//        System.out.println(q);
    }
}
