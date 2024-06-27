package priorityQueueAndDisjointSets.session_3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static void main(String[] args) {

        int a[] = {3, 2, 1, 5, 6, 4};
        int k = 4;
        int ans = kthLargestElement(a,k);

        System.out.println(ans);

    }
    static int kthLargestElement(int a[], int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e: a){
           pq.add(e);
           if(pq.size() > k){
               pq.poll();
           }
        }
        return pq.peek();
    }
    static int kThLargestElementByMe(int a[], int k){
        int n = a.length;
        Arrays.sort(a);
        return a[n-k];
    }
}
