package ab_questionInCourse.dsaArray;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {

        int a[] = {3, 2, 4};
        int target = 6;
        TwoSum obj = new TwoSum();
        int res[] = obj.twoSum(a,target);

        for(int e: res){
            System.out.print(e+" ");
        }

    }
    public int[] twoSum(int[] nums, int target) {
        //You can code here
        int a[] = new int[2];
        int n = nums.length;
//        Arrays.sort(nums);

        for(int i = 0; i < n-1; i++){
            int sum = 0;
            for(int j = i+1; j < n; j++){
                sum = nums[i]+nums[j];
                if(sum != target && nums[i] == nums[j])
                    continue;
                if(sum == target){
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
                sum -= nums[j];
            }
        }
        return a;
    }
}
