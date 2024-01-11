package queues.session_3;

public class ImplementingQueueWithMax {
    public static void main(String[] args) {

        QueueWithMax q = new QueueWithMax();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println(q.getMax());

        System.out.println(q.dequeue());
        q.dequeue();

        System.out.println(q.getMax());

    }
}
