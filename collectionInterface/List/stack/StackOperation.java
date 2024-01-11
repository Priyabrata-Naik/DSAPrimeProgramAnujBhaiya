package collectionInterface.List.stack;

import java.util.Stack;

public class StackOperation {
    public static void main(String[] args) {
        Stack<String> fruit = new Stack<>();

        fruit.push("A");
        fruit.push("B");
        fruit.push("C");
        fruit.push("D");
        fruit.push("E");
        fruit.push("F");

        System.out.println(fruit.pop());
        System.out.println(fruit.peek());

        System.out.println(fruit.empty());

        System.out.println(fruit);


    }
}
