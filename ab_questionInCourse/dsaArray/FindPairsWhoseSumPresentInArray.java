package ab_questionInCourse.dsaArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPairsWhoseSumPresentInArray {
    public static void main(String[] args) {

        int a[] = {10, 4, 8, 13, 5};
        List<List<Integer>> res = findPair(a);

        System.out.println(res);

    }
    static List<List<Integer>> findPair(int arr[]){
        List<List<Integer>> ls = new ArrayList<>();
        int n = arr.length;
        Set<Integer> set = new HashSet<>();

        for(int e: arr){
            set.add(e);
        }

        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int sum = arr[i] + arr[j];
                if(set.contains(sum)){
                    List<Integer> res = new ArrayList<>();
                    res.add(arr[i]);
                    res.add(arr[j]);
                    ls.add(res);
                }
            }
        }



        ls.sort((a,b)->{
            if(!a.get(0).equals(b.get(0))){
                return a.get(0)-b.get(0);
            }else{
                return a.get(1)-b.get(1);
            }
        });

//        System.out.println(ls.get(0).equals(ls.get(0)));
//        System.out.println(ls.get(1));


        return ls;
    }
}
