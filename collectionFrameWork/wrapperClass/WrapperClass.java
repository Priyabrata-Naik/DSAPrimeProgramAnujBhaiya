package collectionFrameWork.wrapperClass;

public class WrapperClass {
    public static void main(String[] args) {
//        This is decrypted, not working by this time
//        Integer obj1 = new Integer(2);
        Integer obj2 = Integer.valueOf(4);
        Integer obj3 = 4;// autoboxing

        int a = obj2; // unboxing
        Integer b = Integer.valueOf("50");
        System.out.println(b*2);

    }
}
