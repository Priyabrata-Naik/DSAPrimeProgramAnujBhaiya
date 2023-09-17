package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PermutationOfAnArray {

    public static void main(String[] args) {
        int a[] = {1,2,3};
        List<List<Integer>> ans= new ArrayList<List<Integer>>();
        ans = permute(a);
        for(List<Integer> e: ans){
            for(int b: e){
                System.out.print(b);
            }
            System.out.println();
        }
    }

//    Need more optimization for edge cases
    public static List<List<Integer>> permute(int[] nums) {
        //You can code here
        List<List<Integer>> ls = new ArrayList<List<Integer>>();

        permuteHelper(nums,0,nums.length-1,ls);
//        Need to know comparator
//        Need more optimisation for both positive and negative test case
        Collections.sort(ls, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                long negativeCount1 = list1.stream().filter(n -> n < 0).count();
                long negativeCount2 = list2.stream().filter(n -> n < 0).count();

                if (negativeCount1 > negativeCount2) {
                    return -1; // list1 has more negatives
                } else if (negativeCount1 < negativeCount2) {
                    return 1;  // list2 has more negatives
                } else {
                    // If the counts are equal, sort by the sum of positive numbers
                    int sum1 = list1.stream().filter(n -> n >= 0).mapToInt(Integer::intValue).sum();
                    int sum2 = list2.stream().filter(n -> n >= 0).mapToInt(Integer::intValue).sum();

                    return Integer.compare(sum1, sum2);
                }
            }
        });
        return ls;
    }

    public static void permuteHelper(int num[],int l,int r,List<List<Integer>> ans){
        if(l == r){
            List<Integer> ls = new ArrayList<>();
            for(int e: num){
                ls.add(e);
            }
            ans.add(ls);
            return;
        }
        for(int i = l; i <= r; i++){
            swap(num,i,l);
            permuteHelper(num,l+1,r,ans);
            swap(num,i,l);
        }
    }

    private static void swap(int[] num, int i, int l) {
        int temp = num[i];
        num[i] = num[l];
        num[l] = temp;
    }

}
