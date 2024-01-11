package ab_questionInCourse.dsaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WaveArray {
    public static void main(String[] args) {

//        int a[] = {4, 3, 5, 1, 2, 8};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(3);
        a.add(5);
        a.add(1);
        a.add(2);
        a.add(8);
        WaveArray obj = new WaveArray();
        ArrayList<Integer> ans =obj.wave(a);

        System.out.println(ans);

    }
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        //You Can Code Here

        Collections.sort(A);

//        for(int e: A){
//            System.out.println(e+" ");
//        }


        for(int i = 1; i < A.size(); i +=2){
//            System.out.println(i+ " " +A.size());
            if(A.get(i) > A.get(i-1)){
                int temp = A.get(i);
                A.set(i,A.get(i-1));
                A.set(i-1, temp);
            }
        }

        return A;
    }
}
