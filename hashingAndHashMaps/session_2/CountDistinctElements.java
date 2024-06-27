package hashingAndHashMaps.session_2;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args) {

        int a[] = {10, 20, 20, 30, 10, 10};
        int res = countDistinctElementsOp(a);

        System.out.println(res);

    }
    static int countDistinctElements(int a[]){
        int count = 1;
        Arrays.sort(a);

        for(int i = 1; i < a.length; i++){
            if(a[i] != a[i-1]){
                count++;
            }
        }
        return count;
    }
    static int countDistinctElementsOp(int a[]){
        HashSet<Integer> set = new HashSet<>();
        for(int e: a){
            set.add(e);
        }
        return set.size();
    }
}
