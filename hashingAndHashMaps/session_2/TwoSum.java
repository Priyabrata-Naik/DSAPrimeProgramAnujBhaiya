package hashingAndHashMaps.session_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

        int a[] = {0, -1, 2, -3, 1};
        int x = -2;
        int res[] = twoSum(a,x);

        System.out.println(res[0] +" "+res[1]);

    }
    static boolean twoSumUsingSet(int a[], int x){
        HashSet<Integer> set = new HashSet<>();

        for(int e: a){
            if(set.contains(x-e)){
                return true;
            }else{
                set.add(e);
            }
        }
        return false;
    }
    static int[] twoSum(int a[], int x){
        int n = a.length;;
        int ans[] = {-1, -1};
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(x-a[i])){
                ans[0] = map.get(x-a[i]);
                ans[1] = i;
                return ans;
            }else{
                map.putIfAbsent(a[i], i);
            }
        }
        return ans;
    }
}
