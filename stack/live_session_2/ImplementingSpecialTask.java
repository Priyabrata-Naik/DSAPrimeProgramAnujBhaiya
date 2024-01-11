package stack.live_session_2;

public class ImplementingSpecialTask {
    public static void main(String[] args) {

        SpecialStack stack = new SpecialStack();

        stack.push(5);
        stack.push(6);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.getMin());
        stack.push(2);
        System.out.println(stack.getMin());

    }
}
