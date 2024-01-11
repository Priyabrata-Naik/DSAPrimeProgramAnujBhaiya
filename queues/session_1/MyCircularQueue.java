package queues.session_1;

public class MyCircularQueue {

    int size;
    int a[];
    int front,rear;
    public MyCircularQueue(int size){
        this.size = size;
        a = new int[size];
        front = rear = -1;
    }

    public boolean isEmpty(){
        return front == -1;
    }
    public boolean isFull(){
        if(front == 0 && rear == size-1)return true;
        if(rear+1 == front)return true;
        return false;
    }
    public boolean enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full, can't add element");
            return false;
        }
        if(isEmpty()){
            front = 0;
        }
        rear = (rear+1)%size;
        a[rear] = data;
        return true;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty, can't remove element");
            return -1;
        }
        int temp = a[front];
        if(front == rear){
            front = rear = -1;
            return temp;
        }
        front = (front+1)%size;
        return temp;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty, can't peek");
            return -1;
        }
        return a[front];
    }
    public void printQueue(){
        if(isEmpty())return;
        if(front <= rear){
            for(int i = front; i <= rear; i++){
                System.out.print(a[i]+" ");
            }
        }else{
            for(int i = front; i < size; i++){
                System.out.print(a[i]+" ");
            }
            for(int i = 0; i <= rear; i++){
                System.out.print(a[i]+" ");
            }
        }
        System.out.println();
    }

}
