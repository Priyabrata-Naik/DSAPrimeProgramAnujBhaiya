package oops2.learnEncapsulation;

import oops2.learningPackages.Person;

public class MainInEncapsulation {

    //	static method can directly accessible by its class it doesn't need any object
    public static void printHello() {
        System.out.println("Hello");
//		cann't put non-static method in static field
//		printHi();
    }

    //	non-static method required object to access the method
    public void printHi() {
        System.out.println("Hi");
        printHello();
    }

    static {
        System.out.println("First static block");
    }

    public static void main(String[] args) {

        System.out.println("Main method");

        Person p1 = new Person();
        p1.setAge(23);
//		Person.count = 50;

        Person p2 = new Person();
        Person p3 = new Person();

//		System.out.println(p1.getAge());
        System.out.println(Person.count);

//		MainInEncapsulation.printHello();

        System.out.println(Person.scientificName);

    }

    static {
        System.out.println("Second static block");
    }

}
