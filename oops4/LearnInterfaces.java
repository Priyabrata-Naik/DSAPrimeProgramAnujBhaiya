package oops4;

public class LearnInterfaces {

    public static void main(String[] args) {

//        Animal a1 = new Animal();
        Monkey m = new Monkey();
        m.eat();
        m.sing();
        m.drinks();
        m.walk();

        System.out.println(Animal.LEGS);

    }

}

interface Pet{
    void sing();
    void drinks();
//    If we use 2 same default fun^ then we have to override that method in its child class
//    default void walk(){
//        System.out.println("Animal is walking");
//    }
}

interface Animal{

//    By default, this field is public static final
    int LEGS = 4;
    void eat();
    void drinks();
    default void walk(){
        System.out.println("Animal is walking");
    }
}

class Monkey implements Animal,Pet{

    @Override
    public void eat() {
        System.out.println("Monkey is eating");
    }

    @Override
    public void drinks() {
        System.out.println("Monkey is drinking");
    }

    @Override
    public void sing() {
        System.out.println("Monkey is singing");
    }
}
