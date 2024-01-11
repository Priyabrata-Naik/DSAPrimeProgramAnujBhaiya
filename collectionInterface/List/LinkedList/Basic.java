package collectionInterface.List.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class Basic {
    public static void main(String[] args) {

        List<Integer> ls = new LinkedList<>();

        ls.add(40);
        ls.add(240);
        ls.add(540);

        System.out.println(ls);
        ls.remove(ls.size()-1);
        System.out.println(ls);

    }
}
