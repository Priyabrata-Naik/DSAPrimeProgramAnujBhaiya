package queues.session_3;

public class ImplementingQueueWithMinAndMax {
    public static void main(String[] args) {

        QueueWithMinAndMax q = new QueueWithMinAndMax();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
//        q.enqueue(5);

        System.out.println(q.getMin());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.getMin());

    }
}
