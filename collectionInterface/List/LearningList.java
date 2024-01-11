package collectionInterface.List;

import java.util.ArrayList;
import java.util.List;

public class LearningList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);

//        System.out.println(list.get(0));
//        list.set(1,200);
//        list.add(2,1000);
//        list.remove(1);
        System.out.println(list.indexOf(20));

        System.out.println(list);


    }
}
