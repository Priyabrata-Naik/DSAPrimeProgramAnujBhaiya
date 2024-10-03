package a_dsaPrimeDoubtNPractice.dsaArray;

public class MaxChunksToMakeSorted_2 {
    public static void main(String[] args) {

        int a[] = {3, 4, 2, 8, 1, 10, 12};
        int ans = maxChunksToSort(a);

        System.out.println(ans);

    }

    static int maxChunksToSort(int a[]){
        if(a == null) return 0;
        int n = a.length;
        if(n == 0) return 0;
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        int chunks = 0;
        leftMax[0] = a[0];
        rightMin[n-1] = a[n-1];

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1], a[i]);
        }
        for(int i = n-2; i >= 0; i--){
            rightMin[i] = Math.min(rightMin[i+1], a[i]);
        }

        for(int i = 0; i < n-1; i++){
            if(leftMax[i] <= rightMin[i+1]) chunks++;
        }

        return chunks+1;
    }
}
