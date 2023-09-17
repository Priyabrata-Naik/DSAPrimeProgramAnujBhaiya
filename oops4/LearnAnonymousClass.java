package oops4;

public class LearnAnonymousClass {

//    class InnerClass extends OuterClass{
//
//    }

//    Creating subclass object(obj) for one time use only
    OuterClass obj = new OuterClass(){
        void sing(){

        }
        public void outerMethod(){
            System.out.println("Overriding method in child class");
        }
    };

    SuperInterface obj2 = new SuperInterface() {
        @Override
        public void interfaceMethod() {
            System.out.println("Interface method from child class");
        }
    };

//    Lambda function without class and method. () define argument if any present
    SuperInterface obj3 = () -> {

    };

    public static void main(String[] args) {
        WalkAble walkAble = (int steps) -> {
            System.out.println("Walked " + steps + " steps");
            return steps;
        };
        walkAble.walks(12);
        WalkAble obj2 = ( step) -> 2*step;

        System.out.println(obj2.walks(10));
    }

}

interface WalkAble{
    int walks(int steps);
}

class OuterClass{
    public void outerMethod(){

    }
}

//It is functional interface as it has only one method in interface
@FunctionalInterface
interface SuperInterface{
    void interfaceMethod();
}
