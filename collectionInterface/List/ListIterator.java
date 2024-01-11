package collectionInterface.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterator {
    public static void main(String[] args) {

        List<String> fruit = new ArrayList<>();

        fruit.add("Kiwi");
        fruit.add("Banana");
        fruit.add("Apple");
        fruit.add("Mango");

        for(int i = 0; i < fruit.size(); i++){
            System.out.println("for loop " + fruit.get(i));
        }

        for(String e: fruit){
            System.out.println("for each loop "+e);
        }

//        Iterator<String> ft = fruit.iterator();
//        Working both as same
        Iterator<String> ft = fruit.listIterator();
        while(ft.hasNext()){
            System.out.println("iterator " + ft.next());
        }

        List<String> smallList = fruit.subList(1,3);
        System.out.println(smallList);

    }
}
