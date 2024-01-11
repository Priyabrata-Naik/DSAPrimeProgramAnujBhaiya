package queues.session_1;

public class ImplementingMyQueue {
    public static void main(String[] args) {

        MyQueue q = new MyQueue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);

        q.printQueue();
        q.dequeue();
        q.dequeue();
        q.dequeue();

        q.printQueue();

        q.enqueue(8);
        q.enqueue(10);

        q.printQueue();

    }
}
