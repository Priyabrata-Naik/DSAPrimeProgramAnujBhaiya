package stack.session_1;

public class StackUsingArrays {
    private int size;
    private int a[];
    private int top;

    public StackUsingArrays(int size){
        this.size = size;
        a = new int[size];
        top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == size - 1;
    }
    public boolean push(int data){
        if(isFull()){
            System.out.println("Stack overflow,can't add item");
            return false;
        }else {
            top++;
            a[top] = data;
            return true;
        }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }else{
            int temp = a[top];
            top--;
            return temp;
        }
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return Integer.MIN_VALUE;
        }else{
            return a[top];
        }
    }
    public void printStack(){
        for(int i = 0; i <= top; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
