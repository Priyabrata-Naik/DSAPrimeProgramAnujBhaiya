package ab_questionInCourse.dsaArray;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(3);
        a.add(2);
        a.add(4);
        a.add(5);

        System.out.println(subUnsort(a));

    }

    static ArrayList<Integer> subUnsort(ArrayList<Integer> A){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = A.size();
        int startIndex = -1;
        int endIndex = -1;

        for(int i = 0; i < n-1; i++){
            if(A.get(i) > A.get(i+1)){
                startIndex = i;
                break;
            }
        }
        if(startIndex == -1) {
            ans.add(-1);
            return ans;
        }
        for(int i = n-1; i > 0; i--){
            if(A.get(i) < A.get(i-1)){
                endIndex = i;
                break;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = startIndex; i <= endIndex; i++){
            min = Math.min(min, A.get(i));
            max = Math.max(max, A.get(i));
        }

        for(int i = 0; i <= startIndex-1; i++){
            if(A.get(i) > min){
                startIndex = i;
                break;
            }
        }

        for(int i = n-1; i >= endIndex+1; i--){
            if(A.get(i) < max){
                endIndex = i;
                break;
            }
        }

        ans.add(startIndex);
        ans.add(endIndex);

//        ans.sort(((o1, o2) -> {
//            return o1.intValue()- o2.intValue();
//        }));

        return ans;
    }
}
