package ab_questionInCourse.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfArrayHelper {
    public static void main(String[] args) {

        int a[] = {1, 2, 3};
        Solution obj = new Solution();
        List<List<Integer>> ans = obj.permute(a);

        System.out.println(ans);

    }

}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] map = new boolean[nums.length];
        permuteHelper(nums, ans, new ArrayList<>(), map);
//        for (List ls : ans) {
//            System.out.println(ls);
//        }
        return ans;
    }

    public void permuteHelper(int[] nums, List<List<Integer>> ans, ArrayList<Integer> ds, boolean[] map) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!map[i]) {
                map[i] = true;
                ds.add(nums[i]);
                permuteHelper(nums, ans, ds, map);
                ds.remove(ds.size() - 1);
                map[i] = false;
            }
        }
    }
}


