package collectionFrameWork.exceptionHandling;

public class MainClass {
    public static void main(String[] args) {

        int[] a = new int[5];
        System.out.println("Hi, good morning");

//        try {
//            int res = 5/0;
//            System.out.println(a[7]);
//        }catch (ArrayIndexOutOfBoundsException e){
//            System.out.println(e);
//            System.out.println("Tried to access out of bound element ");
//        }catch(ArithmeticException e){
//            System.out.println(e.getMessage());
//            System.out.println(e);
//        }

        try {
            int res = 5 / 0;
            System.out.println(a[7]);
//        }catch (ArrayIndexOutOfBoundsException | ArithmeticException | NullPointerException e){
//            System.out.println("Handling the exception");
//        }catch (RuntimeException e){
//            System.out.println("Runtime exception");
//        }
        }catch (Exception e){
            System.out.println("All type exception handled ");
        }

        System.out.println("Hello");

    }
}
