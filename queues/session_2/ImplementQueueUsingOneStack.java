package queues.session_2;

public class ImplementQueueUsingOneStack {
    public static void main(String[] args) {

        QueueUsingOneStack q = new QueueUsingOneStack();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

    }
}
