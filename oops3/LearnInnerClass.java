package oops3;

public class LearnInnerClass {

    class Toy{
        int price;
    }

    static class PlayStation{
        int price;
    }

    public static void main(String[] args) {

        LearnInnerClass obj = new LearnInnerClass();
        Toy t = obj.new Toy();
        t.price = 50;

        PlayStation ps = new LearnInnerClass.PlayStation();
        ps.price = 50000;

    }

}
