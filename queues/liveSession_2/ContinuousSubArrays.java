package queues.liveSession_2;

import java.util.ArrayDeque;

public class ContinuousSubArrays {
    public static void main(String[] args) {

        int a[] = {5, 4, 2, 4};
        int res = continuousSubArrays(a);

        System.out.println(res);

    }
    static int continuousSubArrays(int a[]){
        int n = a.length;
        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        int count = 0;
        int l = 0;

        for(int r = 0; r < n; r++){
            while(!min.isEmpty() && min.getLast() > a[r]){
                min.pollLast();
            }
            min.offerLast(a[r]);
            while(!max.isEmpty() && max.getLast() < a[r]){
                max.pollLast();
            }
            max.offerLast(a[r]);
            while(max.getFirst()-min.getFirst() > 2){
                if(min.getFirst() == a[l]){
                    min.pollFirst();
                }
                if(max.getFirst() == a[l]){
                    max.pollFirst();
                }
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }
}
