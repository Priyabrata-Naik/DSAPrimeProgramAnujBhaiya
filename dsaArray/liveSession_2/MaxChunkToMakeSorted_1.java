package dsaArray.liveSession_2;

public class MaxChunkToMakeSorted_1 {
    public static void main(String[] args) {

        int a[] = {2, 3, 1, 2, 3, 4, 0, 1, 5};

        System.out.println( maxChunk(a));
    }
    static int maxChunk(int a[]){
        if(a.length == 0) return 0;
        int chunk = 0;
        int maxSoFar = a[0];

        for(int i = 0; i < a.length; i++){
            maxSoFar = Math.max(maxSoFar, a[i]);
            if(i == maxSoFar){
                chunk++;
            }
        }
        return chunk;
    }
}
