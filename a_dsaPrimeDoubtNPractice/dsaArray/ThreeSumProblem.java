package a_dsaPrimeDoubtNPractice.dsaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumProblem {
    public static void main(String[] args) {

        int a[] = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> ans = threeSum(a);

        System.out.println(ans);

//        for(int i = 0; i < ans.size(); i++){
//            ans.get(i).add(0, 5);
//            System.out.println(ans.get(i));
//        }

    }

    static ArrayList<ArrayList<Integer>> threeSum(int a[]){
        int n = a.length;
        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-2; i++){
            if(i > 0 && a[i] == a[i-1])
                continue;
            ArrayList<ArrayList<Integer>> cur = twoSum(a, i+1, -a[i]);
//            for(ArrayList<Integer> e: cur){
//                e.add(0, a[i]);
//                ans.add(e);
//            }

            for(int j = 0; j < cur.size(); j++){
                ArrayList<Integer> al = cur.get(j);
//                System.out.println("cur -> " + cur.get(j));
                al.add(0, a[i]);
//                System.out.println("al -> " + al);
                ans.add(al);
            }
        }

//        Collections.sort(ans, (o1, o2) -> {
//            if(o1.get(0).intValue() == o2.get(0).intValue()){
//                return o1.get(1) - o2.get(1);
//            }
//            return o1.get(0) - o2.get(0);
//        });

        return ans;
    }



    static ArrayList<ArrayList<Integer>> twoSum(int a[], int startFrom, int sum){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int left = startFrom;
        int right = a.length - 1;

        while(left < right){
            if(left > startFrom && a[left] == a[left-1]){
                left++;
                continue;
            }

            if(right < a.length - 1 && a[right] == a[right+1]){
                right--;
                continue;
            }

            if(a[left] + a[right] < sum){
                left++;
            }else if(a[left] + a[right] > sum){
                right--;
            }else{
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(a[left]);
                cur.add(a[right]);
                ans.add(cur);
//                System.out.println("twoSum -> " + ans);
                left++;
                right--;
            }
        }

        return ans;
    }

    //    private static boolean isTwoSumPresent(int[] a, int startInd, int sum) {
//        int end = a.length - 1;
//        while(startInd < end){
//
//        }
//    }


//    static ArrayList<ArrayList<Integer>> threeSum(int a[]){
//        int n = a.length;
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//
//        for(int i = 0; i < n-2; i++){
//
//            ArrayList<Integer> cur = twoSum(a, i+1, n-1, -a[i]);
//        }
//
//    }
//    static ArrayList<Integer> twoSum(int a[], int x, int y, int sum){
//        ArrayList<Integer> ans = new ArrayList<>();
//        while(x < y){
//            if(a[x] + a[y] < sum){
//                x++;
//            }else if(a[x] + a[y] > sum){
//                y--;
//            }else{
//                ans.add(a[x]);
//                ans.add(a[y]);
//                x++;
//                y--;
//            }
//        }
//        return ans;
//    }
}
