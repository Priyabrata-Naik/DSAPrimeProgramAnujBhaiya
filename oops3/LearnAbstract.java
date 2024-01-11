package oops3;

public class LearnAbstract {

    public static void main(String[] args) {

//        we can't create object of abstract class
//        Vehicle v1 = new Vehicle();

        Car c1 = new Car();
        c1.accelerate();
        c1.brake(4);
        c1.honks();

    }

}

abstract class Human{
    void speak(){

    }
    abstract void eat();
}

abstract class Vehicle{
    abstract void accelerate();
    abstract int brake(int wheels);
    void honks(){
        System.out.println("Vehicle is honking");
    }

}

class Car extends Vehicle{

    @Override
    void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    int brake(int wheels) {
        System.out.println("Car brakes are pushed");
        return wheels;
    }
}
