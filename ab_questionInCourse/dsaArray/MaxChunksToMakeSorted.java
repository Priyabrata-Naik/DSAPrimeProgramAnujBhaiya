package ab_questionInCourse.dsaArray;

public class MaxChunksToMakeSorted {
    public static void main(String[] args) {

        int[] a = {0, 1, 2, 4, 3, 6, 5};
        int ans = maxChunksToSorted(a);

        System.out.println(ans);

    }

    static int maxChunksToSorted(int[] arr){
        int n = arr.length;
        if(arr == null || n == 0) return 0;
        int ans = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            max = Math.max(max, arr[i]);
            if(i == max){
                ans++;
            }
        }
        return ans;
    }
}
