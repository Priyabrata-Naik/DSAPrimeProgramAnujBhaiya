package collectionInterface;

import java.util.ArrayList;
import java.util.List;

public class CollectionInterfaceMethods {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(10);
        list1.add(20);
        list1.add(30);

        list2.add(200);
        list2.add(500);
        list2.add(30);

//        System.out.println(list1.size());
//        System.out.println(list1.contains(20));

        System.out.println(list1);

//        This removes the value at index
//        list1.remove(1);
////        This remove the exact element from the list1 if present(It takes object as parameter)
//        list1.remove(Integer.valueOf(30));
//        list1.addAll(list2);

//        It works as A - B
//        list1.removeAll(list2);

//        It works as Intersection
//        list1.retainAll(list2);

//        list1.clear();

        Object a[] = list1.toArray();
        for(Object e: a){
            Integer temp = (Integer) e;
            System.out.print(temp*2+ " ");
        }
        System.out.println();

        System.out.println(list1);

    }
}
