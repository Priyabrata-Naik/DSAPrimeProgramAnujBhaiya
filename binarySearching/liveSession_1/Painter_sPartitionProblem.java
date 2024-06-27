package binarySearching.liveSession_1;

public class Painter_sPartitionProblem {
    public static void main(String[] args) {

        int a[] = {10, 10, 10, 10};
        int k = 2;
        int res = paintersPartition(a, k);

        System.out.println(res);

    }
    static int paintersPartition(int a[], int k){
        int l = -1;
        int h = 0;
        for(int e: a){
            l = Math.max(l, e);
            h += e;
        }
        int ans = 0;

        while(l <= h){
            int m = l + (h-l)/2;
            int paintersCount = countPainters(a, m);
            if(paintersCount > k){
                l = m+1;
            }else{
                ans = m;
                h = m-1;
            }
        }
        return ans;
    }
    static int countPainters(int a[], int time){
        int count = 1;
        int sum = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];
            if(sum > time){
                count++;
                sum = a[i];
            }
        }
        return count;
    }
}
