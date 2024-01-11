package collectionFrameWork.generics;

public class Generics {
    public static void main(String[] args) {
        Dog<String,Integer> d1 = new Dog<>("3",40);
        Dog<Integer,Boolean> d2 = new Dog<>(1,true);
        System.out.println(d1.getId());
    }
}
class Dog<E,D>{
    E id;
    D name;

    public Dog(E id, D name){
        this.id = id;
        this.name = name;
    }
    E getId(){
        return id;
    }
}
