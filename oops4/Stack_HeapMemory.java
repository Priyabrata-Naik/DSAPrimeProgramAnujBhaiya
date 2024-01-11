package oops4;

public class Stack_HeapMemory {
    public static void main(String[] args) {
        Integer a = 5;
        Data obj = new Data();
        obj.data = 15;
        changeValue(a,obj);
        System.out.println(a);
//        As non-primitive data are created in heap memory it directly reflects its value
        System.out.println(obj.data);
    }
    static void changeValue(int a,Data obj){
        a = 10;
        obj.data = 100;
    }
}
class Data{
    int data;
    public void printData(){
        System.out.println(data);
    }
    public void printData(int times){
        for(int i = 1; i <= times; i++){
            System.out.println(data);
        }
    }
}