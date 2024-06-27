package priorityQueueAndDisjointSets.liveSession_1;

import java.util.PriorityQueue;

public class MinCostOfRopes {
    public static void main(String[] args) {

        long a[] = {4, 3, 2, 6};
        int n = a.length;
        long ans = minCost(a,n);

        System.out.println(ans);

    }
    static long minCost(long a[], int n){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long cost = 0;

        for(int i = 0; i < n; i++){
            pq.add(a[i]);
        }
        while(pq.size() > 1){
            long ele1 = pq.poll();
            long ele2 = pq.poll();
            cost += ele1 + ele2;
            pq.add(ele1+ele2);
        }
        return cost;
    }
}
