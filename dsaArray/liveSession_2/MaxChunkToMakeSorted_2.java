package dsaArray.liveSession_2;

public class MaxChunkToMakeSorted_2 {
    public static void main(String[] args) {

        int a[] = {4, 2, 1, 3, 6, 8, 5, 10};
        int b[] = {3, 2, 1};

        System.out.println(maxChunkOp(a));

    }
    static int maxChunk(int a[]){
        int n = a.length;
        if(n == 0) return 0;
        int chunks = 0;
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        rightMin[n-1] = a[n-1];
        leftMax[0] = a[0];

        for(int i = 1, j = n-2; i < n && j >= 0; i++, j--){
            leftMax[i] = Math.max(leftMax[i-1], a[i]);
            rightMin[j] = Math.min(rightMin[j+1], a[j]);
        }

        int i = 0, j = i+1;
        while(i < n && j < n){
            if(leftMax[i] < rightMin[j]){
                chunks++;
            }
            i++;
            j++;
        }
        chunks++;
        return chunks;
    }
    static int maxChunkOp(int a[]){
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
            if(leftMax[i] <= rightMin[i+1]){
                chunks++;
            }
        }
        return chunks+1;
    }
}
