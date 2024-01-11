package collectionFrameWork.generics;

public class GenericMethod {
    public static void main(String[] args) {
        printData("Shark");
        printData(32);
        GenericMethod obj = new GenericMethod();
        obj.doubleData(12);
        obj.doubleData("abc");
        CustomClass cs = new CustomClass();
        obj.doubleData(cs);
        obj.addingData(34);
//        We can only add integer & float data to bounded wrapper class
//        obj.addingData("dljw");
    }
    static <E> void printData(E data){
        System.out.println(data);
    }
    <E> void doubleData(E data){
        System.out.println(data);
    }
    <E extends Number> void addingData(E data){
        System.out.println(data);
    }
}
class CustomClass{

}
