package priorityQueueAndDisjointSets.session_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SplitArrayIntoKNonOverlappingSubset {
    public static void main(String[] args) {

        Integer a[] = {1, 7, 9, 2, 12, 3, 3};
        int m = 3;
        int ans = divideSubset(a,m);

        System.out.println(ans);

    }
    static int divideSubset(Integer a[], int m){
        Arrays.sort(a, Collections.reverseOrder());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < m; i++){
            pq.add(0);
        }
        for(int e: a){
            int smallest = pq.remove();
            pq.add(smallest+e);
        }
        for(int i = 0; i < m-1; i++){
            pq.remove();
        }
        return pq.remove();
    }
}
