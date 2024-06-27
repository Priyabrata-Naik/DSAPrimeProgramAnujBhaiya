package hashingAndHashMaps.session_3;

import java.util.*;

public class QuadrupleWithSumEqualToGivenSum {
    public static void main(String[] args) {

//        int a[] = {10, 2, 3, 4, 5, 9, 7, 8};
//        int x = 23;
        int b[] = {10, -10, 0, 0};
        int x = 0;
        List<List<Integer>> ans = findAllQuadrupleWithGivenSum(b,x);

        System.out.println(ans);

    }
    static List<List<Integer>> findAllQuadrupleWithGivenSum(int a[], int k){
        int n = a.length;
        if(n < 4) return null;
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(a);

        for(int i = 0; i < n-3; i++){
            for(int j = i+1; j < n-2; j++){
                List<List<Integer>> tempAns = findAllTwoSum(a,k - a[i] - a[j], j+1);
                for(List<Integer> list: tempAns){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a[i]);
                    temp.add(a[j]);
                    temp.addAll(list);
                    ans.add(temp);
                }
            }
        }
        return new ArrayList<>(ans);
    }
    static List<List<Integer>> findAllTwoSum(int a[], int sum, int start){
        int i = start, j = a.length - 1;
        List<List<Integer>> ans = new ArrayList<>();
        while(i < j){
            if(a[i] + a[j] == sum){
                List<Integer> temp = new ArrayList<>();
                temp.add(a[i]);
                temp.add(a[j]);
                ans.add(temp);
                i++;
                j--;
            }else if(a[i] + a[j] < sum){
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
    static ArrayList<ArrayList<Integer>> quadrupleSumEqualToGivenSum(int a[], int x){
        int n = a.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n-3; i++){
            int sum = 0;
            for(int j = i+1; j < n-2; j++){
                for(int k = j+1; k < n-1; k++){
                    for(int l = k+1; l < n; l++){
                        sum = a[i] + a[j] + a[k] + a[l];
                        if(sum == x){
                            ArrayList<Integer> res = new ArrayList<>();
                            res.add(a[i]);
                            res.add(a[j]);
                            res.add(a[k]);
                            res.add(a[l]);
                            ans.add(res);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
