package hashingAndHashMaps.session_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FrequencyOfAllElementsInAnArray {
    public static void main(String[] args) {

        int a[] = {10, 20, 20, 10, 10, 20, 5, 20};
//        ArrayList<ArrayList<Integer>> ans = freqOfElements(a);
//        System.out.println(ans);
        frequencyOfElements(a);
    }
    static void frequencyOfElements(int a[]){
        Map<Integer,Integer> map = new HashMap<>();

        for(int e: a){
            if(map.containsKey(e)){
                map.put(e, map.get(e)+1);
            }else{
                map.put(e,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+" -> " + entry.getValue());
        }
    }
//    Need proper case handling, logic building in progress
    static ArrayList<ArrayList<Integer>> freqOfElements(int a[]){
        int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        HashSet<HashSet<Integer>> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(a[i] == a[j]){
                    count++;
                }
            }

            HashSet<Integer> res = new HashSet<>();
            res.add(a[i]);
            res.add(count);
            set.add(res);

        }
        return ans;
    }
}
