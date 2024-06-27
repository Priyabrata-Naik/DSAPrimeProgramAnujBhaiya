package hashingAndHashMaps.session_3;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {

        int a[] = {1, 2, 3};
        int k = 3;
        int ans = countSubArrayWithGivenSum(a,k);

        System.out.println(ans);

    }
    static int countSubArrayWithGivenSum(int a[], int k){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int cs = 0;
        set.add(0);

        for(int e: a){
            cs += e;
            if(set.contains(cs-k)){
                count++;
            }
            set.add(cs);
        }
        return count;
    }
}
