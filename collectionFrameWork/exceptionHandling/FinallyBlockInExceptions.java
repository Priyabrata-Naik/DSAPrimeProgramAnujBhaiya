package collectionFrameWork.exceptionHandling;

public class FinallyBlockInExceptions {
    public static void main(String[] args) {
        int a[] = new int[5];
        System.out.println("Hello world");

        try{
//            System.out.println(a[3]);
            System.out.println(a[8]);
        }catch(Exception e){
            System.out.println("Exception handled");
        }finally {
            System.out.println("I will always run ");
        }

        System.out.println("Bye world");
    }
}
