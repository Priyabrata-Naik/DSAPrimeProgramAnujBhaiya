package collectionFrameworkMapAndComparatorComparable.comparableAndComparaator;

import java.util.*;

public class LearningComparator {
    public static void main(String[] args) {

        Animal a1 = new Animal(4,"Tommy",10);
        Animal a2 = new Animal(6,"Jerry",5);
        Animal a3 = new Animal(2,"Leo",3);
        Animal a5 = new Animal(1,"Nebula",7);
        Animal a4 = new Animal(1,"Bruno",7);

        List<Animal> dogs = new ArrayList<>();

        dogs.add(a1);
        dogs.add(a2);
        dogs.add(a3);
        dogs.add(a4);
        dogs.add(a5);

        System.out.println(dogs);
        Collections.sort(dogs, new MyCustomComparator());
//        Using anonymous class for sorting object
//        Collections.sort(dogs, new Comparator<Animal>() {
//            @Override
//            public int compare(Animal o1, Animal o2) {
//                return o1.name.compareTo(o2.name);
//            }
//        });
//        Java 8 using lambda expression
        Collections.sort(dogs, (o1,o2) -> o1.name.compareTo(o2.name));
//        Or we can write it as
        Collections.sort(dogs,(o1,o2)->{
            return o1.name.compareTo(o2.name);
        });

//        Comparing Method
        Collections.sort(dogs, Comparator.comparing(Animal::getAge).thenComparing(Animal::getName));

        System.out.println(dogs);

        int a[][] = {
                {4, 5, 7},
                {6, 4, 1},
                {1, 8, 3}
        };

        Arrays.sort(a,(arr1, arr2) ->{
           return arr1[0]-arr2[0];
        });

        for(int[] e: a){
            for(int d: e){
                System.out.print(d+" ");
            }
            System.out.println();
        }

    }
}
class MyCustomComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
//        return o1.weight - o2.weight;
//        For better resolution use Integer Wrapper Class
        return Integer.compare(o1.weight,o2.weight);
    }
}
