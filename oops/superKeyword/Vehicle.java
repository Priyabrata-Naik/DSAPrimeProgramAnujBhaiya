package oops.superKeyword;

public class Vehicle {
    int wheels;
    final int gears = 6;

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(4);
//        v1.gears = 5;
    }

    String brand;
    public Vehicle(){
        System.out.println("Vehicle is being created");
    }
    public Vehicle(int wheels){
        this.wheels = wheels;
        System.out.println("Vehicle is being created with wheels");
    }
    void start(){
        System.out.println("Vehicle is starting");
    }
    final void accelerate(){
        System.out.println("Vehicle is accelerating");
    }

}
