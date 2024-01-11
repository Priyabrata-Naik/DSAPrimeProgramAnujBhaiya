package ab_questionInCourse.dsaArray;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();

        al.add(1);
        al.add(3);
        al.add(-1);

        int res = maxArr(al);

        System.out.println(res);

    }
    public static int maxArr(ArrayList<Integer> A) {
        //You can code here
        int n = A.size();
        int firstMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            firstMax = Math.max(A.get(i)+i,firstMax);
            firstMin = Math.min(firstMin, A.get(i)+i);
            secondMax = Math.max(A.get(i)-i,secondMax);
            secondMin = Math.min(secondMin, A.get(i)-i);
        }
        int firstDiff = firstMax - firstMin;
        int secondDiff = secondMax - secondMin;

        return Math.max(firstDiff,secondDiff);
    }
}
