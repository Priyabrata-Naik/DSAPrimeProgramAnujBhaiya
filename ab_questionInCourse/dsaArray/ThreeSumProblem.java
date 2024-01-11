package ab_questionInCourse.dsaArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
    public static void main(String[] args) {

//        int nums[] = {-2, 0, 1, 2, 1};
        int nums[] = {-2,-2, 4, 0, -4,-2};
        ThreeSumProblem obj = new ThreeSumProblem();
        List<List<Integer>> ans = obj.threeSum(nums);

        System.out.println(ans);

    }
    public List<List<Integer>> threeSum(int[] nums) {
        //You can code here
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                if(i > 0 && nums[i] == nums[i-1]){
                    break;
                }
                if(nums[j]+nums[k] < -nums[i]){
                    j++;
                }else if(nums[j]+nums[k] > -nums[i]){
                    k--;
                }else{
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    ans.add(res);
                    j++;
                    k--;
                }
            }
//            System.out.println(i+" "+j+" "+k);
        }
        return ans;
    }
}
