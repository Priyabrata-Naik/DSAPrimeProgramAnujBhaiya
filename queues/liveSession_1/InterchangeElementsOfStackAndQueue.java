package queues.liveSession_1;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterchangeElementsOfStackAndQueue {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        System.out.println(s);

        q.add(8);
        q.add(7);
        q.add(6);
        q.add(5);

        System.out.println(q);

        interchangeElementStackAndQueue(s,q,4,4);

    }
//    STILL NEED PROPER CONFIGURATION, LOGIC IS GOOD
    static void interchangeElementStackAndQueue(Stack<Integer> s, Queue<Integer> q, int m, int n){
        int countStack = 0, countQueue = 0;
//        PUSHING N ELEMENTS FROM QUEUE TO STACK
        while(!q.isEmpty()){
            s.push(q.remove());
        }
//        System.out.println("1s--> " +s);
//        PUSHING N ELEMENTS FROM STACK TO QUEUE
        while(countQueue < n){
            q.add(s.pop());
            countQueue++;
        }
//        System.out.println("2q--> " +q);
        while(!s.isEmpty()){
            q.add(s.pop());
        }
//        System.out.println("3q--> " +q);
        countQueue = 0;
        while(countQueue < n){
            s.push(q.remove());
            countQueue++;
        }
//        System.out.println("4s--> " +s);
        while(!q.isEmpty()){
            s.push(q.remove());
        }
//        System.out.println("5s--> " +s);
        while(countStack < m){
            q.add(s.pop());
            countStack++;
        }
//        printStack(s);
//        printQueue(q);
        System.out.println(s);
        System.out.println(q);
    }
//    static void printStack(Stack<Integer> s){
//        while(!s.isEmpty()){
//            System.out.print(s.pop()+" ");
//        }
//        System.out.println();
//    }
//    static void printQueue(Queue<Integer> q){
//        while(!q.isEmpty()){
//            System.out.print(q.remove()+" ");
//        }
//        System.out.println();
//    }
}
