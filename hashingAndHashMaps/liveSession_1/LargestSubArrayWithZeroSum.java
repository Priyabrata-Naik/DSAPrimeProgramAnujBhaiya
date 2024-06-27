package hashingAndHashMaps.liveSession_1;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum {
    public static void main(String[] args) {

        int a[] = {15, -2, 2, -8, 1, 7, 10, 23};
        int ans = largestSubArrayWithZeroSum(a);

        System.out.println(ans);

    }
    static int largestSubArrayWithZeroSum(int a[]){
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cs = 0;
        int maxLength = 0;

        for(int i = 0; i < n; i++){
            cs += a[i];
            if(map.containsKey(cs)){
                maxLength = Math.max(maxLength, i - map.get(cs));
            }else{
                map.put(cs, i);
            }
        }
        return maxLength;
    }
}
