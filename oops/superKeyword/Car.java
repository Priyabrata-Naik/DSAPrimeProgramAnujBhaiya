package oops.superKeyword;

public class Car extends Vehicle{
    String color;
    Car(){
        super(6);
        System.out.println("Car is being created");
    }

    public static void main(String[] args) {
        Car obj = new Car();
        obj.accelerate();
//        System.out.println(obj.wheels);
//        obj.wheels = 4;
//        obj.brand = "Tata";
//        obj.color = "blue";
//        obj.start();
//        System.out.println(obj.wheels);
    }
    void start(){
        super.start();
        System.out.println("Car is starting");
    }
}

