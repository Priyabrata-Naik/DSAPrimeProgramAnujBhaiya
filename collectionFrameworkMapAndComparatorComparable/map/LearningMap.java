package collectionFrameworkMapAndComparatorComparable.map;

import java.util.*;

public class LearningMap {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("in", "India");
        map.put("rs", "Russia");
        map.put("bh", "India");
        map.put("en","England");

        Set<Map.Entry<String,String>> entries = map.entrySet();

        for(Map.Entry<String,String> entry: entries){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        Set<String> keys = map.keySet();
//        ArrayList<String> keys = new ArrayList<>(map.keySet());
//        Collection<String> values = map.values();
//
//        System.out.println(values);
//
//        System.out.println(keys);

//        Updating the value in specified key
//        map.put("in","India2");
//        We can't put same key value pair if it is already present
//        map.put("in","India");

//        System.out.println(map);
//
//        System.out.println(map.remove("rs"));
//        System.out.println(map.containsKey("bh"));
//        System.out.println(map.get("en"));
//        System.out.println(map);
//
//        System.out.println("Contains value: "+ map.containsValue("India"));
//
//        map.remove("en","Britain");
//
//        System.out.println(map);
//
//        System.out.println(map.get("pn"));
//        System.out.println(map.getOrDefault("pn","Others"));

    }
}
