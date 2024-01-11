package queues.session_1;

public class ImplementationOfCircularQueue {
    public static void main(String[] args) {

        MyCircularQueue q = new MyCircularQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(50);

        q.printQueue();
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        q.printQueue();
        q.dequeue();
        q.dequeue();

        q.enqueue(60);
        q.enqueue(70);
        q.enqueue(80);

        q.printQueue();

    }
}
