package collectionInterface.List.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class LearningArrayList {
    public static void main(String[] args) {

        List<Integer> ls = new ArrayList<>();

        ls.add(945);
        ls.add(45);
        ls.add(145);

        ls.remove(Integer.valueOf(45));


        System.out.println(ls);

    }
}
