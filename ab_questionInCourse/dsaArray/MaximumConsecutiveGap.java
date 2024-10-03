package ab_questionInCourse.dsaArray;

import java.util.Arrays;

public class MaximumConsecutiveGap {
    public static void main(String[] args) {

        int a[] = {4, 8, 2, 6, 5};
        int ans = maximumGap(a);

        System.out.println(ans);
        System.out.println(maximumGapWithNoteOp(a));


    }

//    THIS IS THE SOLUTION ACCORDING TO THE QUESTION AS IT HAS A NOTE
    public static int maximumGapWithNoteOp(int[] arr) {

        if (arr.length < 2)
            return 0;

        int n = arr.length;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        int interval = (int)Math.ceil((max - min + 0.0) / (n - 1));

        int[] minBucket = new int[n - 1];
        int[] maxBucket = new int[n - 1];

        Arrays.fill(minBucket, Integer.MAX_VALUE);
        Arrays.fill(maxBucket, -1);

        for (int i = 0; i < n; i++) {
            if (arr[i] == min || arr[i] == max)
                continue;
            int bucketIndex = (arr[i] - min) / interval;
            minBucket[bucketIndex] = Math.min(minBucket[bucketIndex], arr[i]);
            maxBucket[bucketIndex] = Math.max(maxBucket[bucketIndex], arr[i]);
        }

        int prev = min;
        int maxGap = 0;

        for (int i = 0; i < n - 1; i++) {
            if (maxBucket[i] == -1)
                continue;
            maxGap = Math.max(minBucket[i] - prev, maxGap);
            prev = maxBucket[i];
        }

        maxGap = Math.max(max - prev, maxGap);

        return maxGap;
    }

    public static int maximumGap(int[] a) {
        if(a == null) return 0;
        int n = a.length;
        if(n < 2) return 0;
        int maxDiff = Integer.MIN_VALUE;

        Arrays.sort(a);

        for(int i = 1; i < n; i++){
            int diff = a[i] - a[i-1];
            if(diff > maxDiff){
                maxDiff = diff;
            }
        }

        return maxDiff;
    }
}
