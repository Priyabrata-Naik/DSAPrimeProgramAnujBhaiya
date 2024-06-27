package priorityQueueAndDisjointSets.session_4;

import java.util.*;

public class NMaxPairCombination {
    public static void main(String[] args) {

        Integer a[] = {2, 4, 1, 1};
        Integer b[] = {-2, -3, 2, 4};
        int ans[] = combinationSum(a, b);

        for(Integer e: ans){
            System.out.print(e+" ");
        }

    }
    static int[] combinationSum(Integer a[], Integer b[]){
        int n = a.length;
        int ans[] = new int[n];
        int i = 0, j = 0;

        Arrays.sort(a, Collections.reverseOrder());
        Arrays.sort(b, Collections.reverseOrder());

        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2) -> o2.sum-o1.sum);
        HashSet<Data> set = new HashSet<>();

        Data firstData = new Data(a[i]+b[j], i, j);
        pq.add(firstData);
        set.add(firstData);

        for(int ind = 0; ind < n; ind++){
            Data data = pq.poll();
            ans[ind] = data.sum;

            i = data.i;
            j = data.j;
            if(j+1 < n){
                Data d1 = new Data(a[i]+b[j+1], i, j+1);
                if(!set.contains(d1)){
                    pq.add(d1);
                    set.add(d1);
                }
            }
            if(i+1 < n){
                Data d2 = new Data(a[i+1]+b[j], i+1, j);
                if(!set.contains(d2)){
                    pq.add(d2);
                    set.add(d2);
                }
            }
        }
        return ans;
    }
    static class Data{
        int sum, i, j;
        public Data(int sum, int i, int j){
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o == null || getClass() != o.getClass()) return false;
            Data data = (Data) o;
            return i == data.i && j == data.j;
        }
        @Override
        public int hashCode(){
            return Objects.hash(i,j);
        }

    }
}
