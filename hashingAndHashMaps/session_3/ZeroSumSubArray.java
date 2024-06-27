package hashingAndHashMaps.session_3;

import java.lang.reflect.Array;
import java.util.*;

public class ZeroSumSubArray {
    public static void main(String[] args) {

        int a[] = {4, 2, -3, 1, 6, 5, 0, -5};
//        int res[] = zeroSumSubArrayBruteForce(a);
//        System.out.println(res[0]+" "+res[1]);
//
//        ArrayList<ArrayList<Integer>> ans = zeroSumSubArrayWithPrefixSum(a);
//        System.out.println(ans);

        int ans = countSubArrayWithZeroSumOp(a);
        System.out.println(ans);

    }
//    Logic is not build yet
    static ArrayList<ArrayList<Integer>> zeroSumSubArrayWithPointerOp(int a[]){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int cs = 0;
        int n = a.length;
        int prefixSum[] = new int[n];
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> al = new ArrayList<>();

        al.add(-1);
        map.put(0, al);
        for(int i = 0; i < n; i++){
            cs += a[i];
            if(map.containsKey(cs)){
                ArrayList<Integer> ifAl = new ArrayList<>();
                ifAl.add(i);

            }else{
                ArrayList<Integer> elseAl = new ArrayList<>();
                elseAl.add(i);
                map.put(cs, elseAl);
            }
        }
        return ans;
    }
    static int[] zeroSumSubArrayBruteForce(int a[]){
        int n = a.length;
        int ans[] = {-1, -1};

        for(int i = 0; i < n-1; i++){
            int curSum = 0;
            for(int j = i+1; j < n; j++){
                if(curSum == 0){
                    curSum += a[i] + a[j];
                }else{
                    curSum += a[j];
                }
                System.out.println(curSum);
                if(curSum == 0){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    static ArrayList<ArrayList<Integer>> zeroSumSubArrayWithPrefixSum(int a[]){
        int n = a.length;
        int prefixSum[] = new int[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += a[i];
            prefixSum[i] = sum;
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(i == 0){
                    sum = prefixSum[j];
                }else{
                    sum = prefixSum[j] - prefixSum[i-1];
                }
                if(sum == 0){
                    ArrayList<Integer> res = new ArrayList<>();
                    if(i == 0){
                        res.add(0);
                        res.add(j);
                        ans.add(res);
                    }else{
                        res.add(i);
                        res.add(j);
                        ans.add(res);
                    }
                }
            }
        }
        return ans;
    }
    static int countSubArrayWithZeroSumOp(int a[]){
        int count = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        int cs = 0;
        for(int e: a){
            cs += e;
            if(set.contains(cs)){
                count++;
            }else{
                set.add(cs);
            }
        }
        return count;
    }
}
