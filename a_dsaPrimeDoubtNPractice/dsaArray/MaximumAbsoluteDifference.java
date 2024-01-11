package a_dsaPrimeDoubtNPractice.dsaArray;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {

        int a[] = {3, -2, 5, -4};

        System.out.println(maxAbsoluteDiff(a));

    }
    static int maxAbsoluteDiff(int a[]){
        int n = a.length;
        int maxFirst = Integer.MIN_VALUE;
        int minFirst = Integer.MAX_VALUE;
        int maxSecond = Integer.MIN_VALUE;
        int minSecond = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            maxFirst = Math.max(maxFirst,a[i]+i);
            minFirst = Math.min(minFirst, a[i]+i);
            maxSecond = Math.max(maxSecond, a[i]-i);
            minSecond = Math.min(minSecond, a[i]-i);
        }
        int firstDiff = maxFirst - minFirst;
        int secondDiff = maxSecond - minSecond;

        return Math.max(firstDiff,secondDiff);
    }
}
