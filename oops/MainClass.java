package oops;

public class MainClass {
    public static void main(String[] args) {

        Dog d1 = new Dog();
        d1.name = "Tom";
        d1.bark();

        Dog d2 = new Dog();
        d2.name = "Tommy";
        d2.walk();

    }
}
class Dog{
    String name,color;
    int age;
    void walk(){
        System.out.println(name+" is walking");
    }
    void bark(){
        System.out.println(name+" is barking");
    }
}
